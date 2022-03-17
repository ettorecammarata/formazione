package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.model.User;
import com.besidetech.training.converter.ConverterUser;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<UserDto> getAll() throws UserNotFoundException {
        Set<User> collectionOfUsers = userRepository.findAll() ;
        return ConverterUser.convertToSetOfUserDto(collectionOfUsers);
    }

    @Override
    public UserDto findById(Integer id) throws UserNotFoundException {
        Optional<User> tmp = userRepository.findById(id) ;
        if(!tmp.isPresent())
            return null ;
        return  ConverterUser.convertToUserDto(tmp.get())  ;
    }

    @Override
    public List<UserDto> findByCreatedOrderByNameDesc(Date created) {
        List<User> listaUser = userRepository.findByCreatedOrderByNameDesc(created );
        List<UserDto> listaUserDto = new ArrayList<>() ;
        for (User u : listaUser) {
            listaUserDto.add(ConverterUser.convertToUserDto(u)) ;
        }
        return listaUserDto ;
    }

    @Override
    public void save(UserDto user) throws TimesheetException {
        if (userRepository.findByUsername(user.getUsername())==null)
            userRepository.save(ConverterUser.convertToUser(user) ) ;
        else
            throw new TimesheetException("Utente già esistente ") ;
    }

    @Override
    public void delete(Integer id) throws TimesheetException{
        Optional<User> u = userRepository.findById(id) ;
        if (u.isPresent())
            userRepository.delete(u.get());
        else
            throw new TimesheetException("Utente non trovato ") ;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username) ;
    }

    @Override
    public UserDto findByIdDto(Integer id) {
        return ConverterUser.convertToUserDto(userRepository.findById(id).get()) ;
    }

    @Override
    public void update(UserDto userDto) {
        User tmp = ConverterUser.convertToUser(userDto) ;
        userRepository.save(tmp) ;
    }

    @Override
    public User createUser(UserDto userDto) {
        User u = ConverterUser.convertToUser(userDto)  ;


        return null;
    }


}
