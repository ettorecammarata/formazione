package com.besidetech.training.util;


import java.util.*;

public class TestMain {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(new Date());
//        myDays.set(cal.get(Calendar.DATE) , myDays.get(cal.get(Calendar.DATE))+currentCharge.getHours() ) ;
        System.out.println(cal.get(Calendar.DATE));
    }
}
