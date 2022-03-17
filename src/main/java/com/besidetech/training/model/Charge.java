package com.besidetech.training.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="myt_charge")
public class Charge implements Serializable ,Comparable<Charge> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created")
    private Date created;

    @Column(name = "created_by")
    private Integer created_by;

    @Column(name = "last_upd")
    private Date last_upd;

    @Column(name = "last_upd_by")
    private Integer last_upd_by;

    @Column(name = "task_id")
    private Integer task_id;

    @Column(name = "day")
    private Date day;

    @Column(name = "hours")
    private Float hours;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Charge() {
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

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Date getLast_upd() {
        return last_upd;
    }

    public void setLast_upd(Date last_upd) {
        this.last_upd = last_upd;
    }

    public Integer getLast_upd_by() {
        return last_upd_by;
    }

    public void setLast_upd_by(Integer last_upd_by) {
        this.last_upd_by = last_upd_by;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
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
        return "Charge{" +
                "id=" + id +
                "day=" + day +
                ", created=" + created +
                ", user=" + user +
                ", project=" + project.getId() +
                '}';
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Charge other = (Charge) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public int compareTo(Charge o) {
        if (this.getId()>o.getId())
            return 1 ;
        if (this.getId()<o.getId())
            return -1 ;
        return 0;
    }
}
