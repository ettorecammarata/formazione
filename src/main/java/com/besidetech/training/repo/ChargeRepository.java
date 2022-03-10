package com.besidetech.training.repo;
import com.besidetech.training.model.Charge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface ChargeRepository extends CrudRepository <Charge, Integer> {


    Collection<Charge> findByUserIdAndDayBetweenOrderByProjectId(Integer Id , Date dataInizio , Date dataFine ) ;



}
