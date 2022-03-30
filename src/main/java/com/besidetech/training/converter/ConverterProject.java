package com.besidetech.training.converter;

import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;

import java.util.Set;
import java.util.TreeSet;

public class ConverterProject {

    //convertToSetOfProject
    //convertToSetOfProjectDto
    //convertToProject
    //convertToProjectDto

    public static ProjectDto convertToProjectDto(Project project) {
        if(project==null)
            return null ;
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


    public static Project convertToProject(ProjectDto  projectDto)  {
        if(projectDto.equals(null))
            return null ;
        Project project = new Project() ;

        project.setId(projectDto.getId());
        project.setCreated(projectDto.getCreated());
        project.setCreatedBy(projectDto.getCreatedBy());
        project.setLastUpdate(projectDto.getLastUpdate());
        project.setLastUpdateBy(projectDto.getLastUpdateBy());
        project.setName(projectDto.getName());
        project.setPrefix(projectDto.getPrefix());
        project.setDescription(projectDto.getDescription());
        project.setStatus(projectDto.getStatus()) ;
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setEffStartDate(projectDto.getEffStartDate());
        project.setEffEndDate(projectDto.getEffEndDate());
        project.setClient(projectDto.getClient());
        project.setChargableFlag(projectDto.getChargableFlag());

        return project;

    }

    public static Set<ProjectDto> convertToSetOfProjectDto (Set<Project> projectCollection ) {
        if(projectCollection.isEmpty())
            return null ;
        Set<ProjectDto> listaProjectDto = new TreeSet<>() ;
        for (Project p : projectCollection) {
            listaProjectDto.add(convertToProjectDto(p)) ;
        }
        return listaProjectDto ;
    }


    public static Set<Project> convertToSetOfProject (Set<ProjectDto> projectCollection ) {
        Set<Project> lista = new TreeSet<>() ;
        for (ProjectDto p : projectCollection) {
            lista.add(convertToProject(p)) ;
        }
        return lista ;
    }


}