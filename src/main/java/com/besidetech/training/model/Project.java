package com.besidetech.training.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="myt_project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id ; // identificiatore del progetto

    @Column(name="created")
    private Date created  ; //

    @Column(name="created_by")
    private  Integer createdBy ; //

    @Column(name="last_upd")
    private Date lastUpdate ; //

    @Column(name="last_upd_by")
    private Integer lastUpdateBy ; //

    @Column(name="name")
    private  String name ; //

    @Column(name="prefix")
    private String prefix ; //

    @Column(name="description")
    private  String description ; //

//    @Column(name="description_id")
//    private Integer desctiptionId  ; //

    @Column(name="status")
    private String status  ; //

    @Column(name="progress")
    private  Integer progress ; //

    @Column(name="par_project_id")
    private Integer parProjectId  ; //

    @Column(name="start_date")
    private  Date startDate; //

    @Column(name="end_date")
    private Date endDate  ; //

    @Column(name="eff_start_date")
    private  Date effStartDate; //

    @Column(name="eff_end_date")
    private Date effEndDate ; //

    @Column(name="client")
    private String client ; //

    @Column(name="chargeable_flg")
    private Integer chargableFlag ; // chiedere se questo è un boolean


    @OneToMany(mappedBy = "project" , fetch = FetchType.LAZY)
    Set<UserProject> projects = new TreeSet<>() ;


    public Set<UserProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<UserProject> projects) {
        this.projects = projects;
    }

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

//    public Integer getDesctiptionId() {
//        return desctiptionId;
//    }
//
//    public void setDesctiptionId(Integer desctiptionId) {
//        this.desctiptionId = desctiptionId;
//    }

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



    @Override
    public String toString() {
        return "Project{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
