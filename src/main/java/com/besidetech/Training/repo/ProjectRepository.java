package com.besidetech.Training.repo;

import com.besidetech.Training.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>  {

}
