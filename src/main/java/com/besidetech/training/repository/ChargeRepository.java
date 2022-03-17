package com.besidetech.training.repository;
import com.besidetech.training.model.Charge;
import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.*;

@Repository
public interface ChargeRepository extends CrudRepository <Charge, Integer> {

    Collection<Charge> findByUserIdAndDayBetweenOrderByProjectId(Integer Id , Date dataInizio , Date dataFine ) ;
    Set<Charge> findAll () ;
    void delete(Charge charge);
    Optional<Charge> findById (Integer id ) ;
}
