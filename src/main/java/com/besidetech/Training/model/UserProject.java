package com.besidetech.Training.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="myt_user_project")
public class UserProject {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column (name = "created")
    private Date creted  ;

    @Column (name ="last_upd" )
    private Date lasyUpdate ;

    @Column (name = "rollon_date" )
    private Date rollOnDate ;

    @Column (name = "rolloff_date" )
    private Date rollOffDate ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public UserProject () {}

    public Date getCreted() {
        return creted;
    }

    public void setCreted(Date creted) {
        this.creted = creted;
    }

    public Date getLasyUpdate() {
        return lasyUpdate;
    }

    public void setLasyUpdate(Date lasyUpdate) {
        this.lasyUpdate = lasyUpdate;
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
                "user=" + user +
                ", project=" + project +
                '}';
    }
}
