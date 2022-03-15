package com.besidetech.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(Exception e){
        super(e);
    }

    public void printStackTrace(String d) {
        new UserNotFoundException( d);
    }
}
