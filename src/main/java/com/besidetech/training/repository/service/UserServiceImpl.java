package com.besidetech.training.repository.service;

import com.besidetech.training.model.User;
import com.besidetech.training.model.converter.ConverterUser;
import com.besidetech.training.model.dto.UserDto;
import com.besidetech.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
//@Qualifier (//nome_del_Bean)

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository repository ;

    @Override
    public UserDto findByIdDto(Integer id) {
        ConverterUser c = new ConverterUser() ;



        return c.convert(repository.findById(id).get()) ;
    }

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

    @Override
    public UserDto getConverted(User user) {
        return ConverterUser.convert(user) ;
    }

    @Override
    public Set<User> getAll () {
        return repository.findAll() ;
    }
}
