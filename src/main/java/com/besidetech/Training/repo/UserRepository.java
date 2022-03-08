package com.besidetech.Training.repo;

import com.besidetech.Training.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //User findByNameAndSurname (String Name , String Surname) ; // prova query
}
