package com.besidetech.training.service;

import com.besidetech.training.converter.ConverterUser;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Charge;
import com.besidetech.training.converter.ConverterCharge;
import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public Set<ChargeDto> getAll() {
        Set<Charge> collectionOfCharge = chargeRepository.findAll() ;
        if (collectionOfCharge.isEmpty())
            return null ;
        return ConverterCharge.convertToSetOfChargeDto(collectionOfCharge);
    }

    //    @Override
    //    public Optional<Charge> findById(Integer id) {
    //        return chargeRepository.findById(id);
    //    }

    @Override
    public ChargeDto findById(Integer id) {
        Charge chargeTmp = chargeRepository.findById(id).get();
        return ConverterCharge.convertToChargeDto(chargeTmp);
    }

    @Override
    public void save(ChargeDto charge) {
//        chargeRepository.save(charge) ;
    }

    @Override
    public void save(List<ChargeDto> charge) {
        for (ChargeDto c : charge) {
//            chargeRepository.save(c) ;
        }
    }

    @Override
    public void delete(Integer id)throws TimesheetException {
        Optional<Charge> u = chargeRepository.findById(id) ;
        if (u.isPresent())
            chargeRepository.delete(u.get());
        else
            throw new TimesheetException("Utente non trovato ") ;
    }


}