package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/rest/user")
public class UserController extends AbstractResponse<UserDto> {

    @Autowired
    UserService  userService ;

    @GetMapping("/getAll")
    RestCollectionResponse<UserDto> getAllUsers()  {
        Set<UserDto> myResponse = userService.getAll() ;
        if(myResponse==null)
            return createCollectionResponse(502 , "Utenti non trovati " , null) ;
        if (myResponse.isEmpty()  )
            return createCollectionResponse(500 , "Utenti non recuperati " , null) ;
        else
            return createCollectionResponse(200 , "Utenti recuperati correttamente" , myResponse) ;

    }

    @GetMapping(RestResources.FIND+"/{id}")
    RestResponse<UserDto> findId (@PathVariable("id") Integer id ){
        UserDto myUserDto = userService.findById(id) ;
        if (myUserDto==null)
            return createResponse(500 , "Utente {"+ id + "} non trovato " , null ) ;
        else
              return createResponse(200 , "Utente recuperato correttamente" ,myUserDto   ) ;

    }

    @PostMapping("/save")
    RestResponse<UserDto> save (@RequestBody UserDto user) {
        try{
            userService.save(user);
            return createResponse(200 , "Utente salvato con successo" , user ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @DeleteMapping("/delete/{id}")
    RestResponse<UserDto> delete(@PathVariable("id") Integer id){
        try {
            userService.delete(id);
            return createResponse(200 , "Utente eliminato " , null ) ;
        }catch (TimesheetException e ) {
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }


    @RequestMapping("/update/{user}")
    RestResponse<UserDto> update (@RequestBody UserDto user) throws TimesheetException {
        userService.findById(user.getId()) ;
        userService.delete(user.getId());
        try {
            userService.save(user);
            return createResponse(200 , "utente aggiornato correttamente " , user) ;
        }catch ( TimesheetException f ) {
            return createResponse(500 , "utente non aggiornato " , null ) ;
        }
    }

//    @GetMapping("/findByCreatedOrderByNameDesc/{created}")
//    List<User> findByCreatedOrderByNameDesc (@PathVariable("created") Date created  ){
//        List<UserDto> response = userService.findByCreatedOrderByNameDesc(created) ;
//        List<User> myResponse = new ArrayList<>() ;
//        for (UserDto r : response ) {
//            User tmp = new User() ;
//            tmp.setId(r.getId());
//            myResponse.add(tmp) ;
//        }
//        return myResponse ;
//    }


}
