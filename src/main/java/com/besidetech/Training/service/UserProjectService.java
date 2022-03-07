package com.besidetech.Training.service;

import com.besidetech.Training.model.UserProject;

import java.util.Optional;

public interface UserProjectService {

    Optional<UserProject> findById (Long id ) ;
    public void save (UserProject userProject ) ;
    //recuperare userProject (utente.id)
    UserProject findByUserId (Integer id ) ;
}
