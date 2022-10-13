package com.zavialov.daoWithHibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {


    @EmbeddedId
    private PersonalData personalData;

    public String phoneNumber;

    public String city;
}