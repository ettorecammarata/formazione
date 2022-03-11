package com.besidetech.training.model.converter;

import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.UserDto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterUser {
// aggiungere if null per i seguenti dati
// id , created , created_by , last_upd , last_upd_by , username , password ,
// email , actve , gender
        public UserDto convert(UserDto userDto, User user){
        userDto.setUserId(user.getId().toString());
        String createdToString = convertDateToString(user.getCreated()) ;
        userDto.setCreated(createdToString);
        userDto.setCreatedBy(user.getCreated_by().toString()) ;
        String lastUpdateToString = convertDateToString(user.getLast_update()) ;
        userDto.setLastUpd (lastUpdateToString) ;
        userDto.setLastUpdBy(user.getLast_update_by().toString()) ;
        userDto.setUsername(user.getUsername()) ;
        userDto.setPassword(user.getPassword()) ;
        userDto.setEmail (user.getEmail()) ;
        userDto.setActive(user.getActive().toString());
        userDto.setName(user.getName()) ;
        userDto.setSurname(user.getSurname()) ;
        Character c = user.getGender() ;
        userDto.setGender (c.toString()) ;
        userDto.setLevel (user.getLevel()) ;
        userDto.setPhone (user.getPhone()) ;
        userDto.setMobile (user.getMobile()) ;
        userDto.setLoadCost(user.getLoad_cost().toString()) ;
        userDto.setBillCode(user.getBill_code().toString()) ;
        userDto.setSeatCharge(user.getSeat_charge().toString()) ;
        userDto.setDailyHours(user.getDaily_hours().toString()) ;
        userDto.setProfileId(user.getProfile_id().toString());
        userDto.setNote(user.getNote());
        userDto.setConfirmKey(user.getConfirm_key().toString());
        userDto.setAvatar(user.getAvatar());
        userDto.setPageSize(user.getPage_size().toString());
        userDto.setNotification(user.getNotification());
        return userDto ;
    }

    String convertDateToString (Date date) {
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = date ;
        String dateAsString = df.format(today);
        return dateAsString ;
    }

}
