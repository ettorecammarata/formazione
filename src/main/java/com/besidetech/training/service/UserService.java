package com.besidetech.training.service;

import com.besidetech.training.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById (Integer id ) ;
    public void save (User user ) ;
    //User findByNameAndSurname (String Name , String Surname) ;//prova query
    List<User> findByCreatedOrderByNameDesc (Date created  ) ;// da testare ancora
    //findByAgeLessThan


}
