package com.besidetech.training.modelDto;

import java.util.*;

public class ExactMothDateDto {

    private Integer user ;
    private Date date ;
    private Integer year ;

    public ExactMothDateDto() {
        date = new Date() ;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    void extractDate (Date date ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date getBegin (){
        Date begin = new Date( );
        Calendar c = Calendar.getInstance() ;
        c.setTime(this.date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0);
        begin = c.getTime() ;

        return begin ;
    }

    public Date getEnd (){
        Date end = new Date() ;
        Calendar c = Calendar.getInstance() ;
        c.setTime(this.date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59);
        end = c.getTime() ;
        return end ;
    }

}
