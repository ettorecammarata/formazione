package com.besidetech.training.controller;

import com.besidetech.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    UserRepository userRepository ;

}
