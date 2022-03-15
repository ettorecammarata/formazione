package com.besidetech.training.exception;

public class TimesheetException extends Exception {

    private static final long serialVersionUID = 1L;

    public TimesheetException(){
        super();
    }

    public TimesheetException(String message){
        super(message);
    }

    public TimesheetException(Exception e){
        super(e);
    }




}
