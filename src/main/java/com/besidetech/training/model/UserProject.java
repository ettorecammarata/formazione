package com.besidetech.training.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "myt_user_project")
public class UserProject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private Date created;

    @Column(name = "last_upd")
    private Date lastUpdate;

    @Column(name = "rollon_date")
    private Date rollOnDate;

    @Column(name = "rolloff_date")
    private Date rollOffDate;

    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "project_id")
    private Project project;

    public UserProject() {
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getRollOnDate() {

        return rollOnDate;
    }

    public void setRollOnDate(Date rollOnDate) {
        this.rollOnDate = rollOnDate;
    }

    public Date getRollOffDate() {
        return rollOffDate;
    }

    public void setRollOffDate(Date rollOffDate) {
        this.rollOffDate = rollOffDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "UserProject{" +
                "id=" + id +
                user +
                ", project=" + project.getId() +
                '}';
    }
}
