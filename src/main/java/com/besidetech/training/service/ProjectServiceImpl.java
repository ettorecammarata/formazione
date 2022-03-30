package com.besidetech.training.service;

import com.besidetech.training.exception.ProjectNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.converter.ConverterProject;
import com.besidetech.training.modelDto.ProjectDto;
import com.besidetech.training.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;

    @Override
    public ProjectDto findById(Integer id) throws ProjectNotFoundException{
        Optional<Project> OptionalP = projectRepository.findById(id);
        if (OptionalP.isPresent())
            return ConverterProject.convertToProjectDto(OptionalP.get()) ;
        else
            return null;

    }

    @Override
    public void save(Project project) throws TimesheetException {;
       // Project res = ConverterProject.convertToProject(project) ;

            projectRepository.save(project);

    }



    @Override
    public void delete(Integer id) throws TimesheetException {

      Optional <Project> p= projectRepository.findById(id);
        if (p.isPresent()) {
            projectRepository.delete(p.get());
        }
        else
            throw new TimesheetException("impossibile eliminare il progetto perchè non esiste  ");


    }


    @Override
    public Set<ProjectDto> findAll() throws ProjectNotFoundException {
        Set<Project> risultato=projectRepository.findAll();
        Set<ProjectDto> risultatoDto= new TreeSet<>();
        for (Project p :risultato){

            risultatoDto.add(ConverterProject.convertToProjectDto(p));
        }
        return risultatoDto;
    }




}
