package com.besidetech.training.repository;

import com.besidetech.training.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Integer> {
    Optional<UserRole> findByUserId(Integer user) ;

}
