package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Charge;
import com.besidetech.training.converter.ConverterCharge;
import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.repository.ChargeRepository;
import com.besidetech.training.repository.ProjectRepository;
import com.besidetech.training.repository.UserRepository;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Set<ChargeDto> getAll() {
        Set<Charge> collectionOfCharge = chargeRepository.findAll() ;
        if (collectionOfCharge.isEmpty())
            return null ;
        return ConverterCharge.convertToSetOfChargeDto(collectionOfCharge);
    }

    @Override
    public ChargeDto findById(Integer id) {
        Optional<Charge> tmp = chargeRepository.findById(id) ;
        if (!tmp.isPresent())
            return null ;
        return ConverterCharge.convertToChargeDto(tmp.get());
    }

    /*

    @Override
    public void saveAll(List<ChargeDto> charge)throws TimesheetException{
        for (ChargeDto c : charge) {
        if (!chargeRepository.findById(c.getId()).isPresent() )
            chargeRepository.save(ConverterCharge.convertToCharge(c)) ;
        else
            throw new TimesheetException(c.getId() + " già esistente ") ;
        }
    }

     */

    @Override
    public void save(ChargeDto charge) throws TimesheetException {
        if (!chargeRepository.findById(charge.getId()).isPresent() )
            chargeRepository.save(ConverterCharge.convertToCharge(charge)) ;
        else{
            System.err.println(charge.getId());
            throw new TimesheetException("Charge già esistente ") ;
        }
    }

    @Override
    public void delete(ChargeDto charge) throws TimesheetException {
        Optional<Charge> c = chargeRepository.findById(charge.getId()) ;
        if (c.isPresent())
            chargeRepository.delete(c.get());
        else
            throw new TimesheetException("Charge non trovato ") ;
    }

    @Override
    public void saveAll(Map<Integer , List<ChargeDto>> charges ) throws TimesheetException {
        for (Map.Entry<Integer,List<ChargeDto>> m :charges.entrySet()) {
            Integer currentProject = m.getKey() ;
            List<ChargeDto> currentList = m.getValue() ;
            for ( ChargeDto  current : currentList ) {
                if (current.getId()!= null ){
                    if (current.getHours() == null || current.getHours() == 0 ) { // nel momento in cui c'è un id e dobbiamo fare una modifica ma hour è zero allora eliminiamo il record
                        chargeRepository.delete(ConverterCharge.convertToCharge(current));
                    }else{
                        Optional<Charge> c = chargeRepository.findById(current.getId()) ;
                        if (c.isPresent()) {
                            c.get().setHours(current.getHours());
                            chargeRepository.save(c.get()) ;
                        }
                    }
                }else {
                    Optional<Project> concreteProject = projectRepository.findById(currentProject) ;
                    Optional<User> concUser = userRepository.findById(current.getIdUser()) ;
                    if (concreteProject.isPresent() && concUser.isPresent()) {
                        Charge newCharge = ConverterCharge.convertToCharge(current) ;
                        newCharge.setUser(concUser.get() );
                        newCharge.setProject(concreteProject.get());
                        chargeRepository.save(newCharge);
                    }
                }
            }
        }
    }

    @Override
    public void update(ChargeDto chargeDto) {
            chargeRepository.save(ConverterCharge.convertToCharge(chargeDto)) ;
    }





}