package com.besidetech.training.controller;

import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;

import java.util.Set;

public abstract class AbstractResponse<T> {

    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String CHARGE_NOT_FOUND = "Charge non trovato " ;
//    public final String PROJECT_NOT_FOUND = "User non trovato " ;

//    public final String USER_ALREADY_PRESENT = "User non trovato " ;
//    public final String USER_ALREADY_FOUND = "User non trovato " ;

//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;
//    public final String USER_NOT_FOUND = "User non trovato " ;




    protected RestResponse <T> createResponse (Integer status ,String message , T result ) {
        RestResponse response = new RestResponse() ;
        response.setStatus(status);
        response.setMessage(message);
        response.setResult(result);
        return response ;
    }

    protected RestCollectionResponse<T> createCollectionResponse (Integer status ,String message , Set<T> result  ) {
        RestCollectionResponse response = new RestCollectionResponse() ;
        response.setStatus(status);
        response.setMessage(message);
        response.setResult(result);
        return response ;
    }

}
