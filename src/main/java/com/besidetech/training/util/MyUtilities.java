package com.besidetech.training.util;

import com.besidetech.training.modelDto.ChargeDto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static List<ChargeDto> sort(List<ChargeDto> listDto) {
        List<ChargeDto> myListToFill = new ArrayList<>(listDto);
        Collections.sort(myListToFill, new Comparator<ChargeDto>() {

            public int compare(ChargeDto p1, ChargeDto p2) {
                if (p1.getIdProject() != p2.getIdProject())
                    return p1.getIdProject() - p2.getIdProject();
                return p1.getDay().compareTo(p2.getDay()) ;
            }
        });
        return myListToFill;
    }

    public static Integer getMonth (String month ) {
        if (month.length()>3)
            month = month.subSequence(0,3).toString() ;

        switch (month.toLowerCase()) {
            case "jan":
                return 0;
            case "feb":
                return 1;
            case "mar":
                return 2;
            case "apr":
                return 3;
            case "may":
                return 4;
            case "jun":
                return 5;
            case "jul":
                return 6;
            case "aug":
                return 7;
            case "sep":
                return 8;
            case "oct":
                return 9;
            case "nov":
                return 10;
            case "dec":
                return 11;
        }
        return -1;
    }

    public static Integer getEnd (Date date){
        Calendar c = Calendar.getInstance() ;
        c.setTime(date);
        Integer x = c.getActualMaximum((Calendar.DAY_OF_MONTH) );
        return x ;
    }

    public static List<Integer> getListOfProject (Set<ChargeDto> charges ){
        List<Integer> myList = new ArrayList<>();
        for (ChargeDto charge : charges ) {
            if (!myList.contains(charge.getIdProject()))
                myList.add(charge.getIdProject())  ;
        }
        return myList;

    }


    public static void main(String[] args) {
        System.out.println(MyUtilities.getMonth("AugUSt"));
    }
}
