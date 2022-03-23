package com.besidetech.training.converter;

import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;

import java.util.Set;
import java.util.TreeSet;

public class ConverterProject {

    //convertToSetOfProject
    //convertToSetOfProjectDto
    //convertToProject ok
    //convertToProjectDto ok

    public static ProjectDto convertToProjectDto(Project project) {

//        if (Project==null)
//            return null;

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
        projectDto.setStartDate(project.getStartDate());
        projectDto.setStartDate(project.getEndDate());
        projectDto.setStartDate(project.getEffStartDate());
        projectDto.setStartDate(project.getEffEndDate());
        projectDto.setClient(project.getClient());
        projectDto.setChargableFlag(project.getChargableFlag());

        return projectDto ;
    }



    public static Project convertToProject (ProjectDto projectDto){
        if (projectDto==null)
            return null;
        Project projectN= new Project();
        projectN.setId(projectDto.getId());
        projectN.setCreated(projectDto.getCreated());
        projectN.setCreatedBy(projectDto.getCreatedBy());
        projectN.setLastUpdate(projectDto.getLastUpdate());
        projectN.setLastUpdateBy(projectDto.getLastUpdateBy());
        projectN.setName(projectDto.getName());
        projectN.setPrefix(projectDto.getPrefix());
        projectN.setDescription(projectDto.getDescription());
        projectN.setStatus(projectDto.getStatus()) ;
        projectN.setStartDate(projectDto.getStartDate());
        projectN.setStartDate(projectDto.getEndDate());
        projectN.setStartDate(projectDto.getEffStartDate());
        projectN.setStartDate(projectDto.getEffEndDate());
        projectN.setClient(projectDto.getClient());
        projectN.setChargableFlag(projectDto.getChargableFlag());

        return projectN ;
    }



    public static Set<ProjectDto> convertToSetOfProjectDto (Set<Project>  projectsCollection ) {
        if (projectsCollection.isEmpty())
            return null;

        Set<ProjectDto> listaProjectDto = new TreeSet<>() ;

        for (Project p : projectsCollection) {
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