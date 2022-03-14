package com.besidetech.training.repository.service;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.converter.ConverterProject;
import com.besidetech.training.model.dto.ProjectDto;
import com.besidetech.training.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;
    @Override
    public Optional<Project> findById(Integer id) {
        return projectRepository.findById(id);
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
    public ProjectDto getConverted(Project project) {
        ConverterProject converter = new ConverterProject() ;
        return converter.convert(project ) ;
    }

}
