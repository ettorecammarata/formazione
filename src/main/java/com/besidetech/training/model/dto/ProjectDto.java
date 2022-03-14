package com.besidetech.training.model.dto;

import com.besidetech.training.model.converter.MyUtilities;

public class ProjectDto  {

    String id = " ";
    String created = " ";
    String createdBy= " ";
    String lastUpdate= " ";
    String lastUpdateBy= " ";
    String name= " ";
    String prefix= " ";
    String description= " ";
    String championId = " ";
    String status= " ";
    String project= " ";  // si riferisce alla tabella manyToOne quidni gestire la situazione
    String progress= " ";
    String parProject= " ";
    String startDate= " ";
    String endDate= " ";
    String effStartDate= " ";
    String effEndDate= " ";
    String client= " ";
    String chargableFlag= " ";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getParProject() {
        return parProject;
    }

    public void setParProject(String parProject) {
        this.parProject = parProject;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEffStartDate() {
        return effStartDate;
    }

    public void setEffStartDate(String effStartDate) {
        this.effStartDate = effStartDate;
    }

    public String getEffEndDate() {
        return effEndDate;
    }

    public void setEffEndDate(String effEndDate) {
        this.effEndDate = effEndDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getChargableFlag() {
        return chargableFlag;
    }

    public void setChargableFlag(String chargableFlag) {
        this.chargableFlag = chargableFlag;
    }


    @Override
    public String toString() {
        return "ProjectDto{" +
                "id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", project='" + project + '\'' +
                ", progress='" + progress + '\'' +
                ", parProject='" + parProject + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", effStartDate='" + effStartDate + '\'' +
                ", effEndDate='" + effEndDate + '\'' +
                ", client='" + client + '\'' +
                ", chargableFlag='" + chargableFlag + '\'' +
                '}';
    }
}
