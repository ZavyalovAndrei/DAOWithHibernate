package com.zavialov.daoWithHibernate.controller;

import com.zavialov.daoWithHibernate.exeption.EmptyRequestExeption;
import com.zavialov.daoWithHibernate.exeption.NotFindExeption;
import com.zavialov.daoWithHibernate.models.Persons;
import com.zavialov.daoWithHibernate.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<String> getByCity(@RequestParam(name = "city") String city) {
        List<String> result = new ArrayList<>();
                if (city.isEmpty()) {
            throw new EmptyRequestExeption("Field \"city\" is empty!");
        }
        List<Persons> personsList = repository.getPersonsByCity(city);
        if (personsList.isEmpty()) {
            throw new NotFindExeption("Unknown city " + city + "!");
        } else {
            for (Persons person : personsList) {
                result.add(person.getPersonalData().getName() + " " + person.getPersonalData().getSurname());
            }
        }
        return result;
    }

    @ExceptionHandler(EmptyRequestExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveEmptyRequestException(EmptyRequestExeption exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(NotFindExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveNotFindException(NotFindExeption exception) {
        return exception.getMessage();
    }
}