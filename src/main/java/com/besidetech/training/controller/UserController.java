package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.UserDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/rest/user")
public class UserController extends AbstractResponse<User> {

    @Autowired
    UserService  userService ;

    @RequestMapping("/getAll")
    RestCollectionResponse<User> getAllUsers() {
        Set<User> myResponse = new TreeSet<>( );
        try {
            myResponse = userService.getAll() ;
            return createCollectionResponse(200 , "Utenti recuperati correttamente" , myResponse) ;
        }catch ( TimesheetException t ) {
            return createCollectionResponse(500 , "Utenti non recuperati " , null) ;
        }
    }

    @RequestMapping("/find/{id}")
    RestResponse<User> findId (@PathVariable("id") Integer id ){
        Optional<User>  myUser = null ;
        myUser = userService.findById(id) ;
        if (myUser.isPresent())
            return createResponse(200 , "Utente recuperato correttamente" , myUser.get() ) ;
        else
            return createResponse(500 , "Utente {"+ id + "} non trovato " , null ) ;
    }

    @RequestMapping("/save/{user}")
    void save (@PathVariable("user") User user) {
        userService.save(user);
    }

    @RequestMapping("/findByCreatedOrderByNameDesc/{created}")
    List<User> findByCreatedOrderByNameDesc (@PathVariable("created") Date created  ){
        return userService.findByCreatedOrderByNameDesc(created) ;
    }
    @RequestMapping("/delete/{user}")
    void delete(@PathVariable("user") User user){
        userService.delete(user);
    }

    @RequestMapping("/getConverted/{user}")
    UserDto getConverted (@PathVariable("user") User user ) {
        return  userService.getConverted(user) ;
    }

    @RequestMapping("/finddto/{id}")
    UserDto findIdDto (@PathVariable("id") Integer id ) {
        return userService.findByIdDto(id) ;
    }

}
