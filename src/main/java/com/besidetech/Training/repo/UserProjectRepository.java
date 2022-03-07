package com.besidetech.Training.repo;

import com.besidetech.Training.model.UserProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject , Long> {
    UserProject findByUserId (Integer id ) ;
}
