package com.besidetech.training.repository;

import com.besidetech.training.model.Charge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ChargeRepository extends CrudRepository <Charge, Integer> {

    Collection<Charge> findByUserIdAndDayBetweenOrderByProjectId(Integer Id, Date dataInizio, Date dataFine);
    Set<Charge> findAll();
    void delete(Charge charge);
    Optional<Charge> findById(Integer id);
    List<Optional<Charge>> findChargeByProjectId(Integer project);
    Set<Charge> findByDayBetweenAndUserId (Date start , Date end , Integer user )  ;
    Set<Charge> findByDayAndUserId (Date date , Integer user )  ;

}
//    Collection<Charge> findByUserIdAndDayBetweenOrderByProjectId(nuovaClasse (Integer Id, String dataInizio , Integer Anno  ));