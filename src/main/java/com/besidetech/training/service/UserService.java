package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.UserDto;

import java.util.*;

public interface UserService  {

    public Set<UserDto> getAll () throws UserNotFoundException;
    public UserDto findById (Integer id ) throws UserNotFoundException;
    public List<UserDto> findByCreatedOrderByNameDesc (Date created  ) ;// da testare ancora
    public void save (UserDto user ) throws TimesheetException;// sollevare eccezione se l'username dell'utente che vogliamo salvare già esiste
    public void delete(Integer id ) throws TimesheetException;
    public User findByUsername (String username ) ;
    public UserDto findByIdDto (Integer id ) ;

    public void update(UserDto userDto) throws TimesheetException;
    public User createUser (UserDto userDto) ;

}
