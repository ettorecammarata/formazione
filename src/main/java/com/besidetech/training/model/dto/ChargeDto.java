package com.besidetech.training.model.dto;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.converter.MyUtilities;

import java.util.Date;

public class ChargeDto {

    String id = " " ;
    String created = " " ;
    String createdBy = " " ;
    String lastUpdate = " " ;
    String lastUpdateBy = " " ;
    String taskId = " " ;
    String day = " " ;
    String hours = " " ;
    String user = " " ;
    String project = " " ; // si riferisce all'id del project di riferimento
    MyUtilities m = new MyUtilities() ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public MyUtilities getM() {
        return m;
    }

    public void setM(MyUtilities m) {
        this.m = m;
    }

    public ChargeDto () {} ;

    @Override
    public String toString() {
        return "ChargeDto{" +
                "id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", taskId='" + taskId + '\'' +
                ", day='" + day + '\'' +
                ", hours='" + hours + '\'' +
                ", user='" + user + '\'' +
                ", project='" + project + '\'' +
                ", m=" + m +
                '}';
    }
}
