package com.besidetech.training.util;

import com.besidetech.training.modelDto.ChargeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonCreator {

    public static void main(String[] args) {
        Map<Integer, List<ChargeDto>> mappa = new HashMap<>();
        List<ChargeDto> lista1 = new ArrayList<>( );

        ChargeDto c1 = new ChargeDto() ;
        c1.setId(10);
        lista1.add(c1) ;
        mappa.put(1 , lista1) ;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(mappa);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
