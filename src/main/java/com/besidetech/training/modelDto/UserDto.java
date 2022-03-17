package com.besidetech.training.modelDto;

import com.besidetech.training.model.User;

import java.util.Date;
import java.util.List;

public class UserDto implements Comparable<UserDto>{

    private Integer id ;

    private Date created ;

    private Integer created_by ;

    private Date last_update ;

    private Integer last_update_by ;

    private String username ;

    private String password ;

    private String email ;

    private Boolean active ;

    private String name ;

    private String surname ;

    private char gender ;

    private String level ;

    private String phone ;

    private String mobile ;

    private Float load_cost ;

    private Integer bill_code ;

    private Float seat_charge ;

    private Float daily_hours ;

    private Integer profile_id ;

    private String note ;

    private Character confirm_key ;

    private String avatar ;

    private Integer page_size ;

    private String notification ;

//    private List<Integer> projectsDto ;

//    private User user;

//    private Project project;

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

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Integer getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(Integer last_update_by) {
        this.last_update_by = last_update_by;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Float getLoad_cost() {
        return load_cost;
    }

    public void setLoad_cost(Float load_cost) {
        this.load_cost = load_cost;
    }

    public Integer getBill_code() {
        return bill_code;
    }

    public void setBill_code(Integer bill_code) {
        this.bill_code = bill_code;
    }

    public Float getSeat_charge() {
        return seat_charge;
    }

    public void setSeat_charge(Float seat_charge) {
        this.seat_charge = seat_charge;
    }

    public Float getDaily_hours() {
        return daily_hours;
    }

    public void setDaily_hours(Float daily_hours) {
        this.daily_hours = daily_hours;
    }

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getConfirm_key() {
        return confirm_key;
    }

    public void setConfirm_key(Character confirm_key) {
        this.confirm_key = confirm_key;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

//    public List<Integer> getProjectsDto() {
//        return projectsDto;
//    }
//
//    public void setProjectsDto(List<Integer> projectsDto) {
//        this.projectsDto = projectsDto;
//    }

    public UserDto() {
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", created=" + created +
                ", created_by=" + created_by +
                ", last_update=" + last_update +
                ", last_update_by=" + last_update_by +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", level='" + level + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", load_cost=" + load_cost +
                ", bill_code=" + bill_code +
                ", seat_charge=" + seat_charge +
                ", daily_hours=" + daily_hours +
                ", profile_id=" + profile_id +
                ", note='" + note + '\'' +
                ", confirm_key=" + confirm_key +
                ", avatar='" + avatar + '\'' +
                ", page_size=" + page_size +
                ", notification='" + notification + '\'' +
                '}';
    }

        @Override
        public int compareTo(UserDto o) {
            if (this.getId()>o.getId())
                return 1 ;
            if (this.getId()<o.getId())
                return -1 ;
            return 0;
        }
}
