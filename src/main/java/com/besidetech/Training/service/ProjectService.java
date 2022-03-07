package com.besidetech.Training.service;

import com.besidetech.Training.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById (Integer id ) ;
    void save ( Project project) ;
}
