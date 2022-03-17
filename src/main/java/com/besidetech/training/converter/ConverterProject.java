package com.besidetech.training.converter;

import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;

public class ConverterProject {

    //convertToSetOfProject
    //convertToSetOfProjectDto
    //convertToProject
    //convertToProjectDto

    public static ProjectDto convertToProject(Project project) {
        ProjectDto projectDto=new ProjectDto();

        projectDto.setId(project.getId());
        projectDto.setCreated(project.getCreated());
        projectDto.setCreatedBy(project.getCreatedBy());
        projectDto.setLastUpdate(project.getLastUpdate());
        projectDto.setLastUpdateBy(project.getLastUpdateBy());
        projectDto.setName(project.getName());
        projectDto.setPrefix(project.getPrefix());
        projectDto.setDescription(project.getDescription());
        projectDto.setStatus(project.getStatus()) ;
        //projectDto.setProject(project.getProjects());//dubbio grosso grosso
        projectDto.setStartDate(project.getStartDate());
        projectDto.setStartDate(project.getEndDate());
        projectDto.setStartDate(project.getEffStartDate());
        projectDto.setStartDate(project.getEffEndDate());
        projectDto.setClient(project.getClient());
        projectDto.setChargableFlag(project.getChargableFlag());

        return projectDto ;
    }
}