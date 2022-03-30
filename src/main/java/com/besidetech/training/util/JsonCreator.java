package com.besidetech.training.util;

import com.besidetech.training.modelDto.RequestChargeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreator {

    public static void main(String[] args) {

//
        RequestChargeDto test = new RequestChargeDto();
        test.setMonth("March");
        test.setUser(1);
        test.setYear(2022);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(test);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
