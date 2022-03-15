package com.besidetech.training.restmodel;

import java.util.Set;

public class RestCollectionResponse <T>{

    private int status ;
    private String message ;
    private Set<T> result ;

    public RestCollectionResponse () {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<T> getResult() {
        return result;
    }

    public void setResult(Set<T> result) {
        this.result = result;
    }
}
