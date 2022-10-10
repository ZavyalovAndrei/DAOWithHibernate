package com.zavialov.daoWithHibernate.repository;

import com.zavialov.daoWithHibernate.models.PersonalData;
import com.zavialov.daoWithHibernate.models.Persons;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Repository implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p where p.city =: city");
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var persons = Stream.of(Persons.builder().personalData(PersonalData.builder().name("Yan").surname("Fedorov").age(37).build()).phoneNumber("9643675").city("Moscow").build(),
                Persons.builder().personalData(PersonalData.builder().name("Aleksei").surname("Uzenjuk").age(28).build()).phoneNumber("7852323").city("Moscow").build(),
                Persons.builder().personalData(PersonalData.builder().name("Anessa").surname("Lippa").age(27).build()).phoneNumber("45236856").city("Westminster").build(),
                Persons.builder().personalData(PersonalData.builder().name("Vladimir").surname("Kotlyarov").age(34).build()).phoneNumber("1120568").city("Moscow").build(),
                Persons.builder().personalData(PersonalData.builder().name("Billie").surname("Eilish Pirate Baird O'Connell").age(22).build()).phoneNumber("6687993").city("Los-Angeles").build(),
                Persons.builder().personalData(PersonalData.builder().name("Niccolò").surname("Moriconi").age(26).build()).phoneNumber("1351668").city("Napoli").build(),
                Persons.builder().personalData(PersonalData.builder().name("Laura").surname("Pergolizzi").age(41).build()).phoneNumber("41615656").city("Milano").build(),
                Persons.builder().personalData(PersonalData.builder().name("Julia").surname("Zivert").age(31).build()).phoneNumber("3598568552").city("Moscow").build(),
                Persons.builder().personalData(PersonalData.builder().name("Robyn Rihanna").surname("Fenty").age(34).build()).phoneNumber("652006688").city("New-York").build(),
                Persons.builder().personalData(PersonalData.builder().name("Brian Hugh").surname("Warner").age(53).build()).phoneNumber("6565656222").city("Kanton").build()).toList();
        for (Persons person : persons) {
            entityManager.persist(person);
        }
    }
}