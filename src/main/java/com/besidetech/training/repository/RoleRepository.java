package com.besidetech.training.repository;

import com.besidetech.training.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository <Role, Integer> {

}
