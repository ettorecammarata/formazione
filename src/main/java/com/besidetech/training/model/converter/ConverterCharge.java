package com.besidetech.training.model.converter;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.dto.ChargeDto;

public class ConverterCharge {


    MyUtilities m = new MyUtilities() ;

    public ConverterCharge () {}


    public static ChargeDto convert(Charge charge) {
        ChargeDto myCharge = new ChargeDto() ;
        myCharge.setId(charge.getId());
        myCharge.setCreated(charge.getCreated());
        myCharge.setCreated_by(charge.getCreated_by());
        myCharge.setLast_upd(charge.getLast_upd());
        myCharge.setLast_upd_by(charge.getLast_upd_by());
        // user
        // project
        myCharge.setTask_id(charge.getTask_id());
        myCharge.setDay(charge.getDay()) ;
        myCharge.setHours(charge.getHours());

        return myCharge ;
    }


}
