package com.besidetech.training.controller;

import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.UserDto;
import com.besidetech.training.repository.UserRepository;
import com.besidetech.training.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    UserService  userService ;

    @RequestMapping("/getAll")
    Set<User> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping("/find/{id}")
    User findId (@PathVariable("id") Integer id ) {
        return userService.findById(id).get() ;
    }

    @RequestMapping("/save/{user}")
    void save (User user) {
        userService.save(user);
    }

    @RequestMapping("/findByCreatedOrderByNameDesc/{created}")
    List<User> findByCreatedOrderByNameDesc (Date created  ){
        return userService.findByCreatedOrderByNameDesc(created) ;
    }
    @RequestMapping("/delete/{user}")
    void delete(User user){
        userService.delete(user);
    }

    @RequestMapping("/getConverted/{user}")
    UserDto getConverted (User user ) {
       return  userService.getConverted(user) ;
    }

    @RequestMapping("/finddto/{id}")
    UserDto findIdDto (@PathVariable("id") Integer id ) {
        return userService.findByIdDto(id) ;
    }

}
