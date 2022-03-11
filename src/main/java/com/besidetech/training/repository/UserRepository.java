package com.besidetech.training.repository;

import com.besidetech.training.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByCreatedOrderByNameDesc(Date created) ;

    //recuperare tutti gli utenti dato un determinato progetto
    //scorriamo in projects che è un istanza di user_project e andiamo ad iterare su project id
    List<User> findByProjectsProjectId(Integer project) ;



}
