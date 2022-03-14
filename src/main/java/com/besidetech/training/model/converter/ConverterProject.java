package com.besidetech.training.model.converter;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.dto.ProjectDto;

public class ConverterProject {

    ProjectDto p = new ProjectDto() ;
    MyUtilities m = new MyUtilities() ;

    public ConverterProject ( ) {
    }

    public ProjectDto convert (Project project) {

        p.setId(project.getId().toString());
        p.setCreated(m.convertDateToString(project.getCreated()));
        p.setCreatedBy(project.getCreatedBy().toString());
        p.setLastUpdate(m.convertDateToString(project.getLastUpdate()));
        p.setLastUpdateBy(project.getLastUpdateBy().toString());
        p.setName(project.getName());
        p.setPrefix(project.getPrefix());
        p.setDescription(project.getDescription());
        p.setStatus(project.getStatus()) ;
        p.setProject(project.getProjects().toString());//dubbio grosso grosso
        p.setStartDate(m.convertDateToString(project.getStartDate()));
        p.setStartDate(m.convertDateToString(project.getEndDate()));
        p.setStartDate(m.convertDateToString(project.getEffStartDate()));
        p.setStartDate(m.convertDateToString(project.getEffEndDate()));
        p.setClient(project.getClient());
        p.setChargableFlag(project.getChargableFlag().toString());

        return p ;
    }
}