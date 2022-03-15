package com.besidetech.training.model.converter;

import com.besidetech.training.model.User;
import com.besidetech.training.model.UserProject;
import com.besidetech.training.model.dto.UserDto;
import java.util.ArrayList;
import java.util.List;

public class ConverterUser {
// aggiungere if null per i seguenti dati
// id , created , created_by , last_upd , last_upd_by , username , password ,
// email , actve , gender
public ConverterUser () {}

        public static UserDto convert(User user) {
                UserDto userDto = new UserDto() ;
                userDto.setId(user.getId());
                userDto.setCreated(user.getCreated());
                userDto.setCreated_by(user.getCreated_by()) ;
                userDto.setLast_update (user.getLast_update()); ;
                userDto.setLast_update_by(user.getLast_update_by()); ;
                userDto.setUsername(user.getUsername()) ;
                userDto.setPassword(user.getPassword()) ;
                userDto.setEmail (user.getEmail()) ;
                userDto.setActive(user.getActive());
                userDto.setName(user.getName()) ;
                userDto.setSurname(user.getSurname()) ;
                userDto.setGender (user.getGender()) ;
                userDto.setLevel (user.getLevel()) ;
                userDto.setPhone (user.getPhone()) ;
                userDto.setMobile (user.getMobile()) ;
                userDto.setLoad_cost(user.getLoad_cost()) ;
                userDto.setBill_code(user.getBill_code()) ;
                userDto.setSeat_charge(user.getSeat_charge()) ;
                userDto.setDaily_hours(user.getDaily_hours());
                userDto.setProfile_id(user.getProfile_id());
                userDto.setNote(user.getNote());
                userDto.setConfirm_key(user.getConfirm_key());
                userDto.setAvatar(user.getAvatar());
                userDto.setPage_size(user.getPage_size());
                userDto.setNotification(user.getNotification());
                List<Integer> projectsId = new ArrayList<>() ;
                for (UserProject up : user.getProjects()) {
                        projectsId.add(up.getProject().getId()) ;
                }
                userDto.setProjectsDto(projectsId);
                return userDto ;
        }


}
