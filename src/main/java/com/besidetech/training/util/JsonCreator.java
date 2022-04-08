package com.besidetech.training.util;

import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.ExactMothDateDto;
import com.besidetech.training.modelDto.RequestChargeDto;
import com.besidetech.training.modelDto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreator {

    public static void main(String[] args) {
//        RequestChargeDto test = new RequestChargeDto();
//        UserDto test = new UserDto() ;
        User test = new User() ;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(test);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
