package com.besidetech.training.service;

import com.besidetech.training.exception.ProjectNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;
import java.util.Set;

public interface ProjectService {
    public ProjectDto findById (Integer id ) throws ProjectNotFoundException;

    public Set<ProjectDto> findAll() throws ProjectNotFoundException;

    public void save(Project project) throws TimesheetException;

    public void delete(Integer id)throws TimesheetException;

}
