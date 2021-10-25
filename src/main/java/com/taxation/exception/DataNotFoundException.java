package com.taxation.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String s){
        super("No data found!");
    }
}
