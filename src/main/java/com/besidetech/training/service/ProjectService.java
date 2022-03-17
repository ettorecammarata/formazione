package com.besidetech.training.service;

import com.besidetech.training.exception.ProjectNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;
import java.util.Set;

public interface ProjectService {
    public ProjectDto findById (Integer id ) throws ProjectNotFoundException;
    public Set<ProjectDto> findAll() throws TimesheetException;
    //Optional<Project> findById (Integer id ) ;
    public void save ( Project project) ;
    public void delete(Project project);
    public ProjectDto getConverted(Project project ) ;

}
