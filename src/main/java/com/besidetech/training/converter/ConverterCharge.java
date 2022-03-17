package com.besidetech.training.converter;

import com.besidetech.training.model.Charge;
import com.besidetech.training.modelDto.ChargeDto;

import java.util.Set;
import java.util.TreeSet;

public class ConverterCharge {
    //convertToSetOfCharge
    //convertToSetOfChargeDto
    //convertToCharge
    //convertToChargeDto

    public static ChargeDto convertToChargeDto(Charge charge) {
        com.besidetech.training.modelDto.ChargeDto myChargeDto = new com.besidetech.training.modelDto.ChargeDto() ;
        myChargeDto.setId(charge.getId());
        myChargeDto.setCreated(charge.getCreated());
        myChargeDto.setCreated_by(charge.getCreated_by());
        myChargeDto.setLast_upd(charge.getLast_upd());
        myChargeDto.setLast_upd_by(charge.getLast_upd_by());
        // user
        // project
        myChargeDto.setTask_id(charge.getTask_id());
        myChargeDto.setDay(charge.getDay()) ;
        myChargeDto.setHours(charge.getHours());

        return myChargeDto ;
    }

    public static Charge convertToCharge(ChargeDto chargeDto) {
        Charge myChargeNormale = new Charge() ;
        myChargeNormale.setId(chargeDto.getId());
        myChargeNormale.setCreated(chargeDto.getCreated());
        myChargeNormale.setCreated_by(chargeDto.getCreated_by());
        myChargeNormale.setLast_upd(chargeDto.getLast_upd());
        myChargeNormale.setLast_upd_by(chargeDto.getLast_upd_by());
        // user
        // project
        myChargeNormale.setTask_id(chargeDto.getTask_id());
        myChargeNormale.setDay(chargeDto.getDay()) ;
        myChargeNormale.setHours(chargeDto.getHours());

        return myChargeNormale ;
    }

    public static Set<ChargeDto> convertToSetOfChargeDto (Set<Charge> chargeCollection ) {
        if(chargeCollection.isEmpty())
            return null ;
        Set<ChargeDto> listaChargeDto = new TreeSet<>() ;
        for (Charge u : chargeCollection) {
            listaChargeDto.add(convertToChargeDto(u)) ;
        }
        return listaChargeDto ;
    }

    public static Set<Charge> convertToSetOfCharge (Set<ChargeDto> chargeCollection ) {
        Set<Charge> lista = new TreeSet<>() ;
        for (com.besidetech.training.modelDto.ChargeDto u : chargeCollection) {
            lista.add(convertToCharge(u)) ;
        }
        return lista ;
    }

}
