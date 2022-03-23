package com.besidetech.training.service;

import com.besidetech.training.converter.ConverterUser;
import com.besidetech.training.exception.ChargeNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.ChargeMap;
import com.besidetech.training.modelDto.UserDto;
import org.javatuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ChargeService {

    public Set<ChargeDto> getAll () throws ChargeNotFoundException;
    public ChargeDto findById (Integer id ) throws ChargeNotFoundException ;
    //public void saveAll(List<ChargeDto> charge) throws TimesheetException;
    public void save(ChargeDto charge) throws TimesheetException;
    public void delete (ChargeDto charge) throws  TimesheetException ;

//    public void saveAll(Map<Integer, Map<Integer, ChargeDto>> charge) ;

//    void saveAll(Map<Integer, List<Pair<Integer , ChargeDto>>> charge)throws  TimesheetException;


//    void saveAll (Map<Integer,Map<Integer, Charge>> charge ) ;

    void saveAll(Map<Integer,List<ChargeDto>> charge)throws  TimesheetException;
    public void update(ChargeDto chargeDto) ;

}

