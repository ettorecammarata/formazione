package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(RestResources.REST_USER)
public class UserController extends AbstractResponse<UserDto> {

    @Autowired
    UserService  userService ;

    @GetMapping(RestResources.GET_ALL)
    RestCollectionResponse<UserDto> getAllUsers()  {
        Set<UserDto> myResponse = userService.getAll() ;
        if(myResponse==null)
            return createCollectionResponse(502 , "Utenti non trovati " , null) ;
        if (myResponse.isEmpty()  )
            return createCollectionResponse(500 , "Utenti non recuperati " , null) ;
        else
            return createCollectionResponse(200 , "Utenti recuperati correttamente" , myResponse) ;

    }

    @GetMapping(RestResources.FIND+RestResources.ID)
    RestResponse<UserDto> findId (@PathVariable("id") Integer id ){
        UserDto myUserDto = userService.findById(id) ;
        if (myUserDto==null)
            return createResponse(500 , id + USER_NOT_FOUND , null ) ;
        else
              return createResponse(200 , "Utente recuperato correttamente" ,myUserDto   ) ;

    }

    @PostMapping(RestResources.SAVE)
    RestResponse<UserDto> save (@Valid @RequestBody UserDto user ,BindingResult bindingResult ) {
        if (bindingResult.hasErrors()){
            //creare lista BindingResult
            System.err.println("binding result : " +  bindingResult.getFieldError().getDefaultMessage());
            return createResponse(500 , "errore sul campo "+bindingResult.getFieldError() , null ) ;
        }
        try{
            userService.save(user);
            return createResponse(200 , "Utente salvato con successo" , null ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @RequestMapping(RestResources.UPDATE+RestResources.ID)
    RestResponse<UserDto> update ( @RequestBody UserDto user ,@PathVariable("id") Integer id) throws TimesheetException {
        UserDto tmp = userService.findById(id) ;
        user.setId(tmp.getId());
        try {
            userService.update(user);
            return createResponse(200 , "utente aggiornato correttamente " , user) ;
        }catch ( TimesheetException f ) {
            return createResponse(500 , "utente non aggiornato " , null ) ;
        }
    }

    @DeleteMapping(RestResources.DELETE+RestResources.ID)
    RestResponse<UserDto> delete(@PathVariable("id") Integer id){
        try {
            userService.delete(id);
            return createResponse(200 , "Utente eliminato " , null ) ;
        }catch (TimesheetException e ) {
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

}
