package com.besidetech.training.repo;

import com.besidetech.training.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>  {

    // recuperare tutti i progetti dato uno user_id
}
