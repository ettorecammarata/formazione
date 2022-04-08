package com.besidetech.training.util;

import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlCreator {

    public static void main(String[] args) {
        User test = new User() ;
        test.setGender('M');
        XmlMapper objectMapper = new XmlMapper();
        try {
            String json = objectMapper.writeValueAsString(test);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
