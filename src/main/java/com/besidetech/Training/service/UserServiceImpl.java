package com.besidetech.Training.service;

import com.besidetech.Training.model.User;
import com.besidetech.Training.model.UserProject;
import com.besidetech.Training.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.Set;
//@Qualifier (//nome_del_Bean)

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository repository ;
    @Override
    public Optional<User> findById(Integer id) {

        User u = repository.findById(id).get() ;
        Set<UserProject> tmpSet = u.getProjects() ;
        for (UserProject t : tmpSet) {

            System.out.println(t);
        }

            return repository.findById(id) ;
    }

    @Override
    public void save(User user) {
        repository.save(user) ;
    }
}
