package com.besidetech.training.model.dto;

import com.besidetech.training.model.User;

import java.util.Optional;

public class UserDto {

    String userId = " ";
    String created= " ";
    String createdBy= " ";
    String lastUpd= " ";
    String lastUpdBy= " ";
    String username= " ";
    String password= " ";
    String email= " ";
    String active= " ";
    String name= " ";
    String surname= " ";
    String gender= " ";
    String level= " ";
    String phone= " ";
    String mobile= " ";
    String loadCost= " ";
    String billCost= " ";
    String seatCharge= " ";
    String dailyHours= " ";
    String profileId= " ";
    String note= " ";
    String confirmKey= " ";
    String avatar= " ";
    String pageSize= " ";
    String notification= " ";


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getLastUpd() {
        return lastUpd;
    }

    public void setLastUpd(String lastUpd) {
        this.lastUpd = lastUpd;
    }

    public String getLastUpdBy() {
        return lastUpdBy;
    }

    public void setLastUpdBy(String lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getLoadCost() {
        return loadCost;
    }

    public void setLoadCost(String loadCost) {
        this.loadCost = loadCost;
    }

    public String getBillCost() {
        return billCost;
    }

    public void setBillCode(String billCost) {
        this.billCost = billCost;
    }

    public String getSeatCharge() {
        return seatCharge;
    }

    public void setSeatCharge(String seatCharge) {
        this.seatCharge = seatCharge;
    }

    public String getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(String dailyHours) {
        this.dailyHours = dailyHours;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getConfirmKey() {
        return confirmKey;
    }

    public void setConfirmKey(String confirmKey) {
        this.confirmKey = confirmKey;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }


    @Override
    public String toString() {
        return    userId
                + " " +created
                + " " + createdBy
                + " " + lastUpd
                + " " + lastUpdBy
                + " " + username
                + " " + password
                + " " + email
                + " " + active
                + " " + name
                + " " + surname
                + " " + gender
                + " " + level
                + " " + phone
                + " " + mobile
                + " " + loadCost
                + " " + billCost
                + " " + seatCharge
                + " " + dailyHours
                + " " + profileId
                + " " + note
                + " " + confirmKey
                + " " + avatar
                + " " + pageSize
                + " " + notification ;
    }


}
