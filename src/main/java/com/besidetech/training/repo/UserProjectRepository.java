package com.besidetech.training.repo;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.model.UserProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject , Long> {
    UserProject findByUserId (Integer id ) ;

    // dato un progetto restituire tutti gli utenti che ci hanno partecipato
    List<UserProject> findUserByProject (Project project) ;
//    List<User> findUserByProject (Project project) ;



    // dato un progetto restituire tutti gli utenti che ci hanno partecipato entro un range di data
    List<UserProject>findByCreatedBetween (Date start , Date end ) ;
}

