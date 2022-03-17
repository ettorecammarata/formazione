package com.besidetech.training.modelDto;

import java.util.Date;

public class ChargeDto implements Comparable<ChargeDto>{

    private Integer id;

    private Date created;

    private Integer created_by;

    private Date last_upd;

    private Integer last_upd_by;

    private Integer task_id;

    private Date day;

    private Float hours;

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

    public ChargeDto() {
    }

    @Override
    public int compareTo(ChargeDto o) {
        if (this.getId()>o.getId())
            return 1 ;
        if (this.getId()<o.getId())
            return -1 ;
        return 0;
    }
}
