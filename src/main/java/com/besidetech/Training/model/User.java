package com.besidetech.Training.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="myt_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id ; // identificiatore dell'utente

    @Column(name="created")
    private Date created ; // rappresenta la data di creazione dell utente

    @Column(name="creted_by")
    private Integer creted_by ;// rappresenta l id dell'user che effettua la creazione

    @Column(name="last_upd")
    private Date last_update ; // data ultimo aggiornamento

    @Column(name="last_update_by")
    private Integer last_update_by ; // rappresenta l id dell user che effettua l'aggiornamento

    @Column(name="username")
    private String username ; // è anche considerata una chiave primaria all interno del db

    @Column(name="password")
    private String password ; // il campo non puo essere vuoto

    @Column(name="email")
    private String email ;

    @Column(name="active")
    private Boolean active ; // da verificare la reale funzione

    @Column(name="name")
    private String name ; // nome utente

    @Column(name="surname")
    private String surname ; // congome utente

    @Column(name="gender")
    private char gender ; // sesso dell utente

    @Column(name="level")
    private String level ; // livello gerarchico dell utente

    @Column(name="phone")
    private String phone ; // numero di telefono fisso dell utente

    @Column(name="mobile")
    private String mobile ; // numero di telefono mobile dell utente

    @Column(name="load_cost")
    private Float load_cost ; // CHIEDERE A COSA SERVE

    @Column(name="bill_code")
    private Integer bill_code ; // CHIEDERE A COSA SERVE

    @Column(name="seat_charge")
    private Float seat_charge ;// CHIEDERE A COSA SERVE

    @Column(name="daily_hours")
    private Float daily_hours ; // ore giornaliere di lavoro dell'utente

    @Column(name="profile_id")
    private Integer profile_id ; // CHIEDERE A COSA SERVE

    @Column(name="note")
    private String note ; //

    @Column(name="confirm_key")
    private Character confirm_key ; //

    @Column(name="avatar")
    private String avatar ;

    @Column(name="page_size")
    private Integer page_size ;

    @Column(name="notification")
    private String notification ;

    @OneToMany(mappedBy = "user" , fetch=FetchType.LAZY )
    Set<UserProject> projects = new TreeSet<>();

    public Set<UserProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<UserProject> projects) {
        this.projects = projects;
    }

    public User()  {} // costruttore vuoto

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

    public Integer getCreted_by() {
        return creted_by;
    }

    public void setCreted_by(Integer creted_by) {
        this.creted_by = creted_by;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", created=" + created +
                ", creted_by=" + creted_by +
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
}
