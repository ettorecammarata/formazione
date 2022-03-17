package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.converter.ConverterProject;
import com.besidetech.training.modelDto.ProjectDto;
import com.besidetech.training.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;
    @Override
//    public Optional<Project> findById(Integer id) {
//        return projectRepository.findById(id);
//    }

    public ProjectDto findById(Integer id) {
        ProjectDto p = ConverterProject.convertToProject(projectRepository.findById(id).get());
        return p;
   }
    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }


    @Override
    public Set<ProjectDto> findAll() throws TimesheetException {
        Set<Project> risultato=projectRepository.findAll();
        Set<ProjectDto> risultatoDto= new TreeSet<>();
        for (Project p :risultato){
            risultatoDto.add(ConverterProject.convertToProject(p));
        }
        return risultatoDto;
    }


    @Override
    public ProjectDto getConverted(Project project) {
        return ConverterProject.convertToProject(project ) ;
    }

}
