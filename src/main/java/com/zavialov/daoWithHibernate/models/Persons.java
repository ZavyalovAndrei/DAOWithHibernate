package com.zavialov.daoWithHibernate.models;

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