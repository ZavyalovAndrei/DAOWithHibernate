package com.zavialov.daoWithHibernate.exeption;

public class NotFindExeption extends RuntimeException{
    public NotFindExeption(String msg) {
        super(msg);
    }
}