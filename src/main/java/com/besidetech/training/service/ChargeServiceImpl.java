package com.besidetech.training.service;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Charge;
import com.besidetech.training.converter.ConverterCharge;
import com.besidetech.training.model.Project;
import com.besidetech.training.model.User;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.ExactMothDateDto;
import com.besidetech.training.modelDto.MyTimesheetDto;
import com.besidetech.training.modelDto.RequestChargeDto;
import com.besidetech.training.repository.ChargeRepository;
import com.besidetech.training.repository.ProjectRepository;
import com.besidetech.training.repository.UserRepository;
import com.besidetech.training.util.MyUtilities;
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
    public void saveAll(Map<Integer , List<ChargeDto>> charges )  {
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


    @Override
    public List<ChargeDto> findAndSortByDate(ExactMothDateDto currentMonth) // dato un user ottengo tutti i suoi charge do un determinato mese
    {
        Set<Charge> mySet = chargeRepository.findByDayBetweenAndUserId(currentMonth.getBegin(),currentMonth.getEnd(),currentMonth.getUser()) ;
        Set<ChargeDto> mySetDto = ConverterCharge.convertToSetOfChargeDto(mySet) ;
        List<ChargeDto> listDto = mySetDto.stream().toList();

        System.out.println("set");
        for (Charge c :mySet) {
            System.out.println(c);
        }

        System.out.println("mySetDto");
        for (ChargeDto c :mySetDto) {
            System.out.println(c);
        }

        System.out.println("listDto");
        for (ChargeDto c : listDto) {
            System.out.println(c);
        }


        System.out.println("sorted");
        for (ChargeDto c : MyUtilities.sort(listDto)) {
            System.err.println(c);
        }
        return listDto;
    }

    @Override
    public Set<ChargeDto> findSortedCharge(RequestChargeDto currentMonth) throws TimesheetException {
        // mi restituisce i charge di una user ordinati in base al progetto e alla date
        Calendar cal = Calendar.getInstance() ;
        cal.set(currentMonth.getYear() , MyUtilities.getMonth(currentMonth.getMonth()) , 1 , 0 , 0 , 0);
        Date begin = cal.getTime() ;
        cal.set(currentMonth.getYear() , MyUtilities.getMonth(currentMonth.getMonth()) ,MyUtilities.getEnd(begin) , 23 , 59 , 59);
        Date end = cal.getTime() ;

        Set<ChargeDto> mySet = ConverterCharge.convertToSetOfChargeDto(chargeRepository.findByDayBetweenAndUserId(begin,end,currentMonth.getUser())) ;

        return mySet ;












//        System.out.println("Set");
//        for (ChargeDto cMySet :mySet ) {
//            System.err.println(cMySet);
//        }
//
//        List<ChargeDto > listaDisodinata = mySet.stream().toList() ;
//
//        System.out.println("risultato disordinato : ");
//
//        for (ChargeDto c : listaDisodinata) {
//            System.out.println(c);
//        }
//
//        List<ChargeDto > listaOrdinata = MyUtilities.sort(listaDisodinata) ;
//
//        System.out.println("risultato ordinata : ");
//        for (ChargeDto c :listaOrdinata ) {
//            System.out.println(c);
//        }



    }

    @Override
    public MyTimesheetDto getTimesheetDto(RequestChargeDto requestChargeDto) throws Exception {
        Set<ChargeDto> testListaCharges = findSortedCharge(requestChargeDto)  ;
        List<Integer> testProgetti = MyUtilities.getListOfProject(testListaCharges) ;
        MyTimesheetDto m = new MyTimesheetDto();
        m.setProjects(testProgetti);
        m.setCharges(testListaCharges);
        m.fill();
        m.printMySheet();
        return m ;
    }

//    @Override
//    public List<ChargeDto> findAndSortDay(ChargeDayDto chargeDayDto) {
//        return null;
//    }


}