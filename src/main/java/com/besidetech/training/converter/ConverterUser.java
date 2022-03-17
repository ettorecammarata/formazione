package com.besidetech.training.converter;

import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.UserDto;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ConverterUser {

        public static UserDto convertToUserDto (User user) { // OK
                if (user== null)
                        return null ;
                UserDto userDto = new UserDto() ;
                userDto.setId(user.getId());
                userDto.setCreated(user.getCreated());
                userDto.setCreated_by(user.getCreated_by()) ;
                userDto.setLast_update (user.getLast_update());
                userDto.setLast_update_by(user.getLast_update_by());
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
                return userDto ;
        }

        public static User convertToUser(UserDto userDto) {
                if(userDto.equals(null))
                        return null ;
                User userNormale = new User() ;
                userNormale.setId(userDto.getId());
                userNormale.setCreated(userDto.getCreated());
                userNormale.setCreated_by(userDto.getCreated_by());
                userNormale.setLast_update (userDto.getLast_update()); ;
                userNormale.setLast_update_by(userDto.getLast_update_by()); ;
                userNormale.setUsername(userDto.getUsername()) ;
                userNormale.setPassword(userDto.getPassword()) ;
                userNormale.setEmail (userDto.getEmail()) ;
                userNormale.setActive(userDto.getActive());
                userNormale.setName(userDto.getName()) ;
                userNormale.setSurname(userDto.getSurname()) ;
                userNormale.setGender (userDto.getGender()) ;
                userNormale.setLevel (userDto.getLevel()) ;
                userNormale.setPhone (userDto.getPhone()) ;
                userNormale.setMobile (userDto.getMobile()) ;
                userNormale.setLoad_cost(userDto.getLoad_cost()) ;
                userNormale.setBill_code(userDto.getBill_code()) ;
                userNormale.setSeat_charge(userDto.getSeat_charge()) ;
                userNormale.setDaily_hours(userDto.getDaily_hours());
                userNormale.setProfile_id(userDto.getProfile_id());
                userNormale.setNote(userDto.getNote());
                userNormale.setConfirm_key(userDto.getConfirm_key());
                userNormale.setAvatar(userDto.getAvatar());
                userNormale.setPage_size(userDto.getPage_size());
                userNormale.setNotification(userDto.getNotification());
//                List<Integer> projectsId = new ArrayList<>() ;
//                for (UserProject up : userDto.getProjects()) {
//                        projectsId.add(up.getProject().getId()) ;
//                }
//
//                userNormale.setProjectsDto(projectsId);
                return userNormale ;
        }

        public static Set<UserDto> convertToSetOfUserDto (Set<User> userCollection ) {
                if(userCollection.isEmpty())
                        return null ;
                Set<UserDto> listaUserDto = new TreeSet<>() ;
                for (User u : userCollection) {
                        listaUserDto.add(convertToUserDto(u)) ;
                }
                return listaUserDto ;
        }
        public static Set<User> convertToSetOfUser (Set<UserDto> userCollection ) {
                Set<User> lista = new TreeSet<>() ;
                for (UserDto u : userCollection) {
                        lista.add(convertToUser(u)) ;
                }
                return lista ;
        }

}
