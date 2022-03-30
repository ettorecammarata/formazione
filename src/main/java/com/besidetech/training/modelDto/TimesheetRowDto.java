package com.besidetech.training.modelDto;

import java.util.*;

public class TimesheetRowDto { // ex Object_Request

    private Integer projectId ;
    private String projectDescription ;
    private Integer taskId ;
    private List<Float> myDays = new ArrayList<>() ;
    private Set<ChargeDto> mySets = new HashSet<>() ;

    public void compileTable(Set<ChargeDto> charges) {
        for (ChargeDto currentCharge : charges) {
            if(currentCharge.getIdProject() == projectId) {
                taskId = currentCharge.getTask_id();
                Calendar cal = Calendar.getInstance();
                cal.setTime(currentCharge.getDay());
                myDays.set(cal.get(Calendar.DATE), myDays.get(cal.get(Calendar.DATE)) + currentCharge.getHours()); // all'indice i assegno il numero di ore di un charge
            }
        }
    }

    public TimesheetRowDto() {
        for (int i = 0 ; i < 32 ; i++ )
            myDays.add(0f) ;
    }

    public List<Float> getMyDays() {
        return myDays;
    }

    public void setMyDays(List<Float> myDays) {
        this.myDays = myDays;
    }

    public Set<ChargeDto> getMySets() {
        return mySets;
    }

    public void setMySets(Set<ChargeDto> mySets) {
        this.mySets = mySets;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void printTimesheetRow() {
        System.out.print ("[ " + projectId + "] ----->");
        for (int i = 1 ; i < myDays.size(); i++) {
            if (i < 10)
                System.out.print("[ " + i + " ] ");
            else
                System.out.print("[ " + i + " ]");
        }
        System.out.println();
        System.out.print ("[---------->");
        for (int i = 1 ; i < myDays.size(); i++) {
            System.out.print("[" + myDays.get(i) + "] ");
        }
        System.out.println();
    }
}
