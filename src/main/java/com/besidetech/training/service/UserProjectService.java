package com.besidetech.training.service;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.model.UserProject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserProjectService {

    Optional<UserProject> findById (Long id ) ;
    public void save (UserProject userProject ) ;
    UserProject findByUserId (Integer id ) ;
    List<UserProject> findUserByProject (Project project) ;
    List<UserProject>findByCreatedBetween (Date start , Date end ) ;

}
