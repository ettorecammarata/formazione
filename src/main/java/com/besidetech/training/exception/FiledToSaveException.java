package com.besidetech.training.exception;

public class FiledToSaveException extends Exception{

    private static final long serialVersionUID = 1L;

    public FiledToSaveException(){
        super();
    }

    public FiledToSaveException(String message){
        super(message);
    }

    public FiledToSaveException(Exception e){
        super(e);
    }
}
