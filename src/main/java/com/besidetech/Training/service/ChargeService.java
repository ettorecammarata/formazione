package com.besidetech.Training.service;

import com.besidetech.Training.model.Charge;
import com.besidetech.Training.model.Project;

import java.util.List;
import java.util.Optional;

public interface ChargeService {

    Optional<Charge> findById (Integer id ) ;
    void save ( List<Charge> charge) ;


}
