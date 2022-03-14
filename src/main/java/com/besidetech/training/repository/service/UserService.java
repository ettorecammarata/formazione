package com.besidetech.training.repository.service;

import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.UserDto;

import java.util.*;

public interface UserService {

    UserDto findByIdDto (Integer id ) ;
    Optional<User> findById (Integer id ) ;
    public void save (User user ) ;
    //User findByNameAndSurname (String Name , String Surname) ;//prova query
    List<User> findByCreatedOrderByNameDesc (Date created  ) ;// da testare ancora

    void delete(User user);
    UserDto getConverted (User user ) ;
    Set<User> getAll () ;
}
