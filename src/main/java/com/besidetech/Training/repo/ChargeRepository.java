package com.besidetech.Training.repo;
import com.besidetech.Training.model.Charge;
import com.besidetech.Training.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChargeRepository extends CrudRepository <Charge, Integer> {


   //assicurarsi che funzioni realmente - Da Testare -
   List<Charge> findByUserIdAndDayBetween(Integer Id , Date dataInizio , Date dataFine ) ;
}
