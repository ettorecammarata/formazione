package com.besidetech.training.service;

import com.besidetech.training.exception.ChargeNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.exception.UserNotFoundException;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.UserDto;

import java.util.List;
import java.util.Set;

public interface ChargeService {

    public Set<ChargeDto> getAll () throws ChargeNotFoundException;
    public ChargeDto findById (Integer id ) throws ChargeNotFoundException ;
    public void save ( ChargeDto charge) throws TimesheetException;
    public void save ( List<ChargeDto> charge) ;
    public void delete(Integer id) throws TimesheetException;




}
