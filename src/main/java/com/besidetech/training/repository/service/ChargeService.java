package com.besidetech.training.repository.service;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.ChargeDto;
import com.besidetech.training.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface ChargeService {

    Optional<Charge> findById (Integer id ) ;
    void save ( List<Charge> charge) ;
//    ChargeDto converti () ;
    ChargeDto getConverted (Charge charge ) ;

}
