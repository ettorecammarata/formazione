package com.besidetech.training.repository;

import com.besidetech.training.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>  {

    //recuperare tutti i progetti dato uno user_id
    //scorriamo in projects che è un istanza di user_project e andiamo ad iterare su user id
    List<Project> findByProjectsUserId(Integer user) ;
   Set <Project> findAll ();

}
