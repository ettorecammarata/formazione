package com.besidetech.training.modelDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyTimesheetDto {

    private List<Integer> projects ;
    private RequestChargeDto requestChargeDto;
    private List<TimesheetRowDto> myList = new ArrayList<>();
    private Set<ChargeDto> charges ;

    public void  fill () {
        for (Integer current : projects ) {
            TimesheetRowDto tmp = new TimesheetRowDto();
            tmp.setProjectId(current);
            tmp.setProjectDescription("description Test");
            tmp.setMySets(charges);
            tmp.compileTable(charges);
            myList.add(tmp) ;
        }
    }

    public List<Integer> getProjects() {
        return projects;
    }

    public void setProjects(List<Integer> projects) {
        this.projects = projects;
    }

    public RequestChargeDto getRequestChargeDto() {
        return requestChargeDto;
    }

    public void setRequestChargeDto(RequestChargeDto requestChargeDto) {
        this.requestChargeDto = requestChargeDto;
    }

    public List<TimesheetRowDto> getMyList() {
        return myList;
    }

    public void setMyList(List<TimesheetRowDto> myList) {
        this.myList = myList;
    }

    public Set<ChargeDto> getCharges() {
        return charges;
    }

    public void setCharges(Set<ChargeDto> charges) {
        this.charges = charges;
    }

    public void printMySheet () {
        for (TimesheetRowDto list : myList) {
            list.printTimesheetRow();
        }
    }

//    TimesheetRowDto rigaTabella = new TimesheetRowDto() ;
//    RequestChargeDto richiesta = new RequestChargeDto() ;



}
