package com.besidetech.training.service;


import com.besidetech.training.model.Charge;
import com.besidetech.training.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public Optional<Charge> findById(Integer id) {
        return chargeRepository.findById(id);
    }

    @Override
    public void save(List<Charge> charge) {
        for (Charge c : charge) {
            chargeRepository.save(c) ;
        }
    }


}

