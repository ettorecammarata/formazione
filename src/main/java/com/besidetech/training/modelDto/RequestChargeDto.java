package com.besidetech.training.modelDto;

public class RequestChargeDto { // RequestChargeDate

    Integer user ;
    String month ;
    Integer Year ;

    public RequestChargeDto() {}

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    @Override
    public String toString() {
        return "MonthYearDto{" +
                "user=" + user +
                ", month='" + month + '\'' +
                ", Year=" + Year +
                '}';
    }
}
