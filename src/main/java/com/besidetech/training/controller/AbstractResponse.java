package com.besidetech.training.controller;

import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;

import java.util.Set;

public abstract class AbstractResponse<T> {



    public static final String BINDIG_RESULT = "Binding result : " ;
    public static final String ERROR_IN_FIELD = "Errore sul campo ";

    public static final String GET_TIMESHEET = "Timesheet recuperato correttamente " ;
    public static final String FAILED_GET_TIMESHEET = "Timesheet non recuperato ";

    public static final String CHARGE_SAVE = "Charge salvato con successo ";
    public static final String CHARGE_NOT_FOUND = "Charge non trovato " ;
    public static final String CHARGE_GET = "Charge recuperato correttamente ";
    public static final String CHARGE_UPDATE = "Charge aggiornato correttamente ";
    public static final String CHARGE_FAILED_UPDATE = "Charge aggiornato correttamente ";
    public static final String CHARGE_DELETE = "Charge cancellato con successo " ;
    public static final String CHARGE_SAVED = "Charge salvato con successo " ;
    public static final String CHARGE_GET_LIST = "Lista recuperata " ;

    public static final String USER_GET = "Utente recuperato correttamente " ;
    public static final String USER_SAVE = "Utente salvato con successo " ;
    public static final String USER_UPDATE = "Utente aggiornato correttamente " ;
    public static final String USER_FAILED_UPDATE = "Utente non aggiornato " ;
    public static final String USER_DELETE = "Utente eliminato " ;
    public static final String USER_ALREADY_EXISTING = "Utente già esistente " ;
    public static final String USER_NOT_FOUND = "User non trovato " ;

    public static final String LOG_WELCOME = "Welcome! Check out the Logs to see the output : " ;
    public static final String LOG_TRACE = "A TRACE Message" ;
    public static final String LOG_DEBUG = "A DEBUG Message" ;
    public static final String LOG_INFO = "An INFO Message" ;
    public static final String LOG_WARN = "A WARN Message" ;
    public static final String LOG_ERROR = "An ERROR Message" ;

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
