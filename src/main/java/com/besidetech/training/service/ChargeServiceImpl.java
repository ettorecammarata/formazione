package com.besidetech.training.service;

import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.model.Charge;
import com.besidetech.training.model.User;
import com.besidetech.training.model.converter.ConverterCharge;
import com.besidetech.training.model.dto.ChargeDto;
import com.besidetech.training.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public List<Charge> getAll() {
        return chargeRepository.findAll();
    }

    @Override
    public Optional<Charge> findById(Integer id) {
        return chargeRepository.findById(id);
    }

    @Override
    public void save(Charge charge) {
        chargeRepository.save(charge) ;
    }

    @Override
    public void save(List<Charge> charge) {
        for (Charge c : charge) {
            chargeRepository.save(c) ;
        }
    }

    @Override
    public void delete(Charge charge) {
        chargeRepository.delete(charge);
    }

    @Override
    public ChargeDto getConverted(Charge charge) {
        ConverterCharge converter  = new ConverterCharge() ;
        return converter.convert(charge) ;
    }

}