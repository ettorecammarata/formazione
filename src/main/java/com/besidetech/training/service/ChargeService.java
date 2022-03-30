package com.besidetech.training.service;

import com.besidetech.training.exception.ChargeNotFoundException;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.ExactMothDateDto;
import com.besidetech.training.modelDto.MyTimesheetDto;
import com.besidetech.training.modelDto.RequestChargeDto;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ChargeService {

    public Set<ChargeDto> getAll () throws ChargeNotFoundException;


    public ChargeDto findById (Integer id ) throws ChargeNotFoundException ;
    public void save(ChargeDto charge) throws TimesheetException;
    public void delete (ChargeDto charge) throws  TimesheetException ;
    void saveAll(Map<Integer,List<ChargeDto>> charge)throws  TimesheetException;
    public void update(ChargeDto chargeDto) ;

    /*
     * Nato come metodo di test :
     * Restituisce tutti i Charges relativi a un Oggetto ExactMontDto che altro non è che una copia
     * di RequestChargeDto
     */
    List<ChargeDto> findAndSortByDate (ExactMothDateDto currentMonth ) throws  TimesheetException;

    /**
     *Restituisce un set di charge che hanno come particolarità il fatto di essere ordinati in base al progetto
     * e al giorno indicato ne charge  . Quindi possiamo dire che sono ordinati e raggruppati
     */
    Set<ChargeDto> findSortedCharge(RequestChargeDto currentMonth ) throws  TimesheetException;

    /*
    *Restituisce un Oggetto MyTimeshett che contine una lista di row (alla fine rappresenterà qualcosa di simile ad
    * una matrice ) . Ogni riga della tabella è rappresentata come segue :
    * ProjectID ----- DescriptionProject ----- Lista dei 31 giorni del mese
    */
    MyTimesheetDto getTimesheetDto (RequestChargeDto requestChargeDto) throws Exception ;

}

//    public void saveAll(List<ChargeDto> charge) throws TimesheetException;
//    public void saveAll(Map<Integer, Map<Integer, ChargeDto>> charge) ;
//    void saveAll(Map<Integer, List<Pair<Integer , ChargeDto>>> charge)throws  TimesheetException;
//    void saveAll (Map<Integer,Map<Integer, Charge>> charge ) ;
