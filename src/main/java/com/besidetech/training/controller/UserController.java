package com.besidetech.training.controller;

import com.besidetech.training.controller.logger.LoggingController;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(RestResources.REST_USER)
public class UserController extends AbstractResponse<UserDto> {

    @Autowired
    UserService userService;
    @Autowired
    LoggingController loggingController ;

    @GetMapping(RestResources.GET_ALL)
    RestCollectionResponse<UserDto> getAll() {
        Set<UserDto> myUserDto = userService.getAll();
        if (myUserDto.isEmpty())
            return createCollectionResponse(500,  AbstractResponse.USER_NOT_FOUND, null);
        else
            return createCollectionResponse(200, AbstractResponse.USER_GET, myUserDto);
    }


    @GetMapping(RestResources.FIND + RestResources.ID)
    RestResponse<UserDto> findId(@PathVariable("id") Integer id) {
        UserDto myUserDto = userService.findById(id);
        if (myUserDto == null)
            return createResponse(500, id + AbstractResponse.USER_NOT_FOUND, null);
        else
            return createResponse(200, AbstractResponse.USER_GET, myUserDto);
    }

//    il file XML da postare deve essere wrappato tra i tag <Creation></Creation>
    @PostMapping(value = RestResources.SAVE)
    RestResponse<UserDto> save(@Valid @RequestBody UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //creare lista BindingResult
            System.err.println(AbstractResponse.BINDIG_RESULT + bindingResult.getFieldError().getDefaultMessage());
            return createResponse(500, AbstractResponse.ERROR_IN_FIELD + bindingResult.getFieldError(), null);
        }
        try {
            userService.save(user);
            return createResponse(200, AbstractResponse.USER_SAVE, null);
        } catch (TimesheetException e) {
            return createResponse(500, e.getMessage(), null);
        }
    }

    @RequestMapping(RestResources.UPDATE + RestResources.ID)
    RestResponse<UserDto> update(@RequestBody UserDto user, @PathVariable("id") Integer id) throws TimesheetException {
        UserDto tmp = userService.findById(id);
        user.setId(tmp.getId());
        try {
            userService.update(user);
            return createResponse(200, AbstractResponse.USER_UPDATE, user);
        } catch (TimesheetException f) {
            return createResponse(500, AbstractResponse.USER_FAILED_UPDATE, null);
        }
    }

    @DeleteMapping(RestResources.DELETE + RestResources.ID)
    RestResponse<UserDto> delete(@PathVariable("id") Integer id) {
        try {
            userService.delete(id);
            return createResponse(200, AbstractResponse.USER_DELETE, null);
        } catch (TimesheetException e) {
            return createResponse(500, e.getMessage(), null);
        }
    }

}
