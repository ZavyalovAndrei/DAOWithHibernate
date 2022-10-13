package com.zavialov.daoWithHibernate.repository;

import com.zavialov.daoWithHibernate.entity.PersonalData;
import com.zavialov.daoWithHibernate.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Persons, PersonalData> {
    List<Persons> findByCity(String name);

    List<Persons> findByPersonalData_AgeLessThanOrderByPersonalData_Age(int age);

    Optional<Persons> findByPersonalData_NameAndPersonalData_Surname(String name, String surname);
}
