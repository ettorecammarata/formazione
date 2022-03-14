package com.besidetech.training.repository.service;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.ProjectDto;
import com.besidetech.training.model.dto.UserDto;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById (Integer id ) ;
    void save ( Project project) ;
    void delete(Project project);
    ProjectDto getConverted(Project project ) ;
}
