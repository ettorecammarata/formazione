package com.besidetech.Training.service;

import com.besidetech.Training.model.UserProject;
import com.besidetech.Training.repo.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
