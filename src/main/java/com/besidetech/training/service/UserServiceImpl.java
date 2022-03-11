package com.besidetech.training.service;

import com.besidetech.training.model.User;
import com.besidetech.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;
//@Qualifier (//nome_del_Bean)

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository repository ;
    @Override
    public Optional<User> findById(Integer id) {
        return  repository.findById(id)  ;
    }

    @Override
    public void save(User user) {
        repository.save(user) ;
    }

    @Override
    public List<User> findByCreatedOrderByNameDesc(Date created) {
        return repository.findByCreatedOrderByNameDesc(created );
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }


}
