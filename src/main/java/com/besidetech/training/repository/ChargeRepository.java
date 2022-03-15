package com.besidetech.training.repository;
import com.besidetech.training.model.Charge;
import com.besidetech.training.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChargeRepository extends CrudRepository <Charge, Integer> {

    Collection<Charge> findByUserIdAndDayBetweenOrderByProjectId(Integer Id , Date dataInizio , Date dataFine ) ;
    List<Charge> findAll () ;
    void delete(Charge charge);
    Optional<Charge> findById (Integer id ) ;
}
