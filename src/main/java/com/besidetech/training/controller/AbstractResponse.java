package com.besidetech.training.controller;

import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;

import java.util.Set;

public abstract class AbstractResponse<T> {

    public static final String USER_NOT_FOUND = "User non trovato " ;

    public static final String BINDIG_RESULT = "Binding result : " ;
    public static final String ERROR_IN_FIELD = "Errore sul campo ";

    public static final String GET_TIMESHEET = "Timesheet recuperato correttamente " ;
    public static final String FAILED_GET_TIMESHEET = "Timesheet non recuperato ";

    public static final String SAVED_CHARGE = "Charge salvato con successo ";
    public static final String CHARGE_NOT_FOUND = "Charge non trovato " ;
    public static final String CHARGE_IDENTIFIED = "Charge recuperato correttamente ";
    public static final String CHARGE_UPDATED = "Charge aggiornato correttamente ";
    public static final String CHARGE_NOT_UPDATED = "Charge aggiornato correttamente ";
    public static final String CHARGE_DELETED = "Charge cancellato con successo " ;
    public static final String CHARGE_SAVED = "Charge salvato con successo " ;
    public static final String LIST_OF_CHARGE = "Lista recuperata " ;

    public static final String GETTED_USER = "Utente recuperato correttamente " ;
    public static final String SAVED_USER = "Utente salvato con successo " ;
    public static final String USER_UPDATED = "Utente aggiornato correttamente " ;
    public static final String USER_NOT_UPDATED = "Utente non aggiornato " ;
    public static final String USER_DELETED = "Utente eliminato " ;



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
