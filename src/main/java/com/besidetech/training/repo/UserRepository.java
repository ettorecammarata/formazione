package com.besidetech.training.repo;

import com.besidetech.training.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //User findByNameAndSurname (String Name , String Surname) ; // prova query
    List<User> findByCreatedOrderByNameDesc(Date created) ;

    //recuperare tutti gli utenti dato un determinato progetto

}
