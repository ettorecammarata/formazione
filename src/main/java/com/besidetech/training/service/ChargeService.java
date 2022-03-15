package com.besidetech.training.service;

import com.besidetech.training.model.Charge;
import com.besidetech.training.model.User;
import com.besidetech.training.model.dto.ChargeDto;
import java.util.List;
import java.util.Optional;

public interface ChargeService {

    public List<Charge> getAll () ;
    public Optional<Charge> findById (Integer id ) ;
    public void save ( Charge charge) ;
    public void save ( List<Charge> charge) ;
    public void delete(Charge charge);
    public ChargeDto getConverted (Charge charge ) ;

}
