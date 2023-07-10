package com.educandoweb.course.services.exceptions;

public class EntityFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public EntityFoundException(String msg) {
        super(msg);
    }
}
