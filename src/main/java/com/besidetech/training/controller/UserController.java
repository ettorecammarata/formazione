package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(RestResources.REST_USER)
public class UserController extends AbstractResponse<UserDto> {

    @Autowired
    UserService userService;

    @GetMapping(RestResources.FIND + RestResources.ID)
    RestResponse<UserDto> findId(@PathVariable("id") Integer id) {
        UserDto myUserDto = userService.findById(id);
        if (myUserDto == null)
            return createResponse(500, id + AbstractResponse.USER_NOT_FOUND, null);
        else
            return createResponse(200, AbstractResponse.GETTED_USER , myUserDto);
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
            return createResponse(200, AbstractResponse.SAVED_USER, null);
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
            return createResponse(200, AbstractResponse.USER_UPDATED, user);
        } catch (TimesheetException f) {
            return createResponse(500, AbstractResponse.USER_NOT_UPDATED, null);
        }
    }

    @DeleteMapping(RestResources.DELETE + RestResources.ID)
    RestResponse<UserDto> delete(@PathVariable("id") Integer id) {
        try {
            userService.delete(id);
            return createResponse(200, AbstractResponse.USER_DELETED, null);
        } catch (TimesheetException e) {
            return createResponse(500, e.getMessage(), null);
        }
    }

}
