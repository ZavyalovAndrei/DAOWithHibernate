package com.zavialov.daoWithHibernate.exeption;

public class EmptyRequestExeption extends RuntimeException{
    public EmptyRequestExeption(String msg) {
        super(msg);
    }
}