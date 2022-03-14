package com.besidetech.training.model.converter;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.dto.ChargeDto;

import java.util.Date;

public class ConverterCharge {

    MyUtilities m = new MyUtilities() ;

    public ConverterCharge () {}


    public static ChargeDto convert(Charge charge) {
        ChargeDto returnDto = new ChargeDto() ;

        Date date1 = charge.getCreated() ;
        Date date2 = charge.getLast_upd() ;
        Date date3 = charge.getDay();
        returnDto.setId(charge.getId().toString());
//        returnDto.setCreated(m.convertDateToString(date1));
        returnDto.setCreatedBy(charge.getCreated_by().toString());
//        returnDto.setLastUpdate(m.convertDateToString(date2));
        returnDto.setLastUpdateBy(charge.getLast_upd_by().toString());
        returnDto.setTaskId(charge.getTask_id().toString());
//        returnDto.setDay(m.convertDateToString(date3));
        returnDto.setHours(charge.getHours().toString());
        returnDto.setUser(charge.getUser().toString());
        returnDto.setProject(charge.getProject().toString());

        return returnDto ;
    }


}
