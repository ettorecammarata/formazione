package com.besidetech.training.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtilities {
    private String pattern = "dd/MM/yyyy HH:mm:ss";
    DateFormat df = new SimpleDateFormat(pattern);

    public MyUtilities() {}

    public String convertDateToString (Date date) {
        return df.format(date) ;
    }

    public Date convertStringToDate (String dateOrigin ) throws ParseException {
        return df.parse(dateOrigin) ;
    }

}
