package com.besidetech.training.modelDto;

import java.util.Date;

public class ProjectDto  implements Comparable<ProjectDto> {

    private Integer id ; // identificiatore del progetto

    private Date created  ; //

    private  Integer createdBy ; //

    private Date lastUpdate ; //

    private Integer lastUpdateBy ; //

    private  String name ; //

    private String prefix ; //

    private  String description ; //

    private String championId ;

    private String status  ; //

    private  Integer progress ; //

    private Integer parProjectId  ; //

    private  Date startDate; //

    private Date endDate  ; //

    private  Date effStartDate; //

    private Date effEndDate ; //

    private String client ; //

    private Integer chargableFlag ; // chiedere se questo è un boolean


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
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

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getParProjectId() {
        return parProjectId;
    }

    public void setParProjectId(Integer parProjectId) {
        this.parProjectId = parProjectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEffStartDate() {
        return effStartDate;
    }

    public void setEffStartDate(Date effStartDate) {
        this.effStartDate = effStartDate;
    }

    public Date getEffEndDate() {
        return effEndDate;
    }

    public void setEffEndDate(Date effEndDate) {
        this.effEndDate = effEndDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getChargableFlag() {
        return chargableFlag;
    }

    public void setChargableFlag(Integer chargableFlag) {
        this.chargableFlag = chargableFlag;
    }

    public ProjectDto() {
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", created=" + created +
                ", createdBy=" + createdBy +
                ", lastUpdate=" + lastUpdate +
                ", lastUpdateBy=" + lastUpdateBy +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", description='" + description + '\'' +
                ", championId='" + championId + '\'' +
                ", status='" + status + '\'' +
                ", progress=" + progress +
                ", parProjectId=" + parProjectId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", effStartDate=" + effStartDate +
                ", effEndDate=" + effEndDate +
                ", client='" + client + '\'' +
                ", chargableFlag=" + chargableFlag +
                '}';
    }

    @Override
    public int compareTo(ProjectDto o) {
        if (this.getId()>o.getId())
            return 1 ;
        if (this.getId()<o.getId())
            return -1 ;
        return 0;
    }
}
