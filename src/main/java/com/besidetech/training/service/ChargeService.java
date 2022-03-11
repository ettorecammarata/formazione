package com.besidetech.training.service;

import com.besidetech.training.model.Charge;

import java.util.List;
import java.util.Optional;

public interface ChargeService {

    Optional<Charge> findById (Integer id ) ;
    void save ( List<Charge> charge) ;
//    ChargeDto converti () ;

}
