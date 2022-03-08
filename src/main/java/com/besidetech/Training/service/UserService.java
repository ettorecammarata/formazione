package com.besidetech.Training.service;

import com.besidetech.Training.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById (Integer id ) ;
    public void save (User user ) ;
    //User findByNameAndSurname (String Name , String Surname) ;//prova query
}
