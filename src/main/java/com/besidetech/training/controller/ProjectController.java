package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/rest/project")
public class ProjectController extends AbstractResponse<Project>{

    @Autowired
    ProjectService projectService ;

    @RequestMapping (RestResources.FIND+ "/{id}")
    RestResponse<Project> findId(@PathVariable("id") Integer id ) {
        ProjectDto myProjectDto = projectService.findById(id) ;
        Project project = new Project() ;
        project.setId(myProjectDto.getId());
        if (!myProjectDto.equals(null))
            return createResponse(200 , "Pogetto recuperato correttamente" , project ) ;
        else
            return createResponse(500 , "Pogetto {"+ id + "} non trovato " , null ) ;
    }


    @RequestMapping("/getAll")
    RestCollectionResponse<Project> getAllProject() {
        try {
            Set<ProjectDto> myResponseDto = projectService.findAll();
            Set<Project> myResponse = new TreeSet<>();
            for (ProjectDto p : myResponseDto) {
                Project tmp = new Project();
                tmp.getId();
                myResponse.add(tmp);
            }
            return createCollectionResponse(200, "Pogetti recuperati correttamente", myResponse);
        } catch ( TimesheetException t ) {
            return createCollectionResponse(500 , "Pogetti non recuperati " , null) ;
        }

    }

}
