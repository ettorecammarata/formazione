package com.besidetech.training.service;

import com.besidetech.training.model.User;
import com.besidetech.training.model.UserProject;
import com.besidetech.training.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
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

    @Override
    public List<User> findByCreatedOrderByNameDesc(Date created) {
        return repository.findByCreatedOrderByNameDesc(created );
    }

 /*   @Override
    public User findByNameAndSurname(String Name, String Surname) {
        return repository.findByNameAndSurname(Name , Surname); // prova query
    }
 */
}
