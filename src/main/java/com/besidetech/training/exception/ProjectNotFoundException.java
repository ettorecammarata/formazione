package com.besidetech.training.exception;

import java.util.NoSuchElementException;

public class ProjectNotFoundException extends NoSuchElementException {


    private static final long serialVersionUID = 1L;

    public ProjectNotFoundException(){
        super();
    }

    public ProjectNotFoundException(String message){
        super(message);
    }

    public ProjectNotFoundException(Exception e){
        super(e);
    }


}
