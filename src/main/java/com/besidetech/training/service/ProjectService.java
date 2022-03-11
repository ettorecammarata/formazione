package com.besidetech.training.service;

import com.besidetech.training.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById (Integer id ) ;
    void save ( Project project) ;
    void delete(Project project);

}
