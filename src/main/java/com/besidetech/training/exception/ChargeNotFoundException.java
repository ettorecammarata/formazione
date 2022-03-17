package com.besidetech.training.exception;

import java.util.NoSuchElementException;

public class ChargeNotFoundException extends NoSuchElementException {

    private static final long serialVersionUID = 1L;

    public ChargeNotFoundException(){
        super();
    }

    public ChargeNotFoundException(String message){
        super(message);
    }

    public ChargeNotFoundException(Exception e){
        super(e);
    }


}
