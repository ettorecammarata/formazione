package com.besidetech.training.controller;

import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.modelXml.UserXML;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(RestResources.REST_XML_USER)
public class UserControllerXML extends AbstractResponse<UserDto> {

    @Autowired
    UserService userService ;

    @GetMapping(value = RestResources.GET_ALL , produces= MediaType.APPLICATION_XML_VALUE )
    RestCollectionResponse<UserDto> getAllUsers()  {

        Set<UserDto> myResponse = userService.getAll() ;

        if(myResponse==null)
            return createCollectionResponse(502 , "Utenti non trovati " , null) ;
        if (myResponse.isEmpty()  )
            return createCollectionResponse(500 , "Utenti non recuperati " , null) ;
        else
            return createCollectionResponse(200 , "Utenti recuperati correttamente" , myResponse ) ;

    }

}
