package com.besidetech.training.service;

import com.besidetech.training.model.Project;
import com.besidetech.training.repo.ProjectRepository;
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


}
