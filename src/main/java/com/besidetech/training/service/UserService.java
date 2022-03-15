package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

public interface UserService  {

    public Set<User> getAll () throws TimesheetException;
    public Optional<User> findById (Integer id ) throws UserNotFoundException;
    public void save (User user ) ;
    public void delete(User user);
    public List<User> findByCreatedOrderByNameDesc (Date created  ) ;// da testare ancora

    public UserDto findByIdDto (Integer id ) ;
    public UserDto getConverted (User user ) ;


}
