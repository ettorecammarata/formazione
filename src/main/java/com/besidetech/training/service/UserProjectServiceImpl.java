package com.besidetech.training.service;

import com.besidetech.training.model.Project;
import com.besidetech.training.model.UserProject;
import com.besidetech.training.repository.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserProjectServiceImpl implements  UserProjectService{

    @Autowired
    private UserProjectRepository userProjectRepository ;
    @Override
    public Optional<UserProject> findById(Long id) {
        return userProjectRepository.findById(id);
    }

    @Override
    public void save(UserProject userProject) {
        userProjectRepository.save(userProject) ;
    }

    @Override
    public UserProject findByUserId(Integer id) {
        return userProjectRepository.findByUserId(id);
    }

    @Override
    public List<UserProject> findUserByProject(Project project) {
        return null;
    }

//    @Override
//    public List<UserProject> findUserByProject(Project project) {
//        return userProjectRepository.findUserByProject(project);
//    }

    @Override
    public List<UserProject> findByCreatedBetween(Date start, Date end) {
        return userProjectRepository.findByCreatedBetween (start ,  end );
    }



}
