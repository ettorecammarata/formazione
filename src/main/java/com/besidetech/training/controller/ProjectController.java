package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Project;
import com.besidetech.training.modelDto.ProjectDto;
import com.besidetech.training.restmodel.CreateVoidResponse;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/project")
public class ProjectController extends AbstractResponse<ProjectDto>{

    @Autowired
    ProjectService projectService ;

    @GetMapping(RestResources.FIND+ "/{id}")
    RestResponse<ProjectDto> findId(@PathVariable("id") Integer id ) {
        ProjectDto myProjectDto = projectService.findById(id) ;

        if (myProjectDto==null)
            return createResponse(500 , "Pogetto {"+ id + "} non trovato " , null ) ;

        else
            return createResponse(200 , "Pogetto recuperato correttamente" , myProjectDto ) ;

    }


    @GetMapping("/getAll")
    RestCollectionResponse<ProjectDto> getAllProject() {
            Set<ProjectDto> myResponseDto = projectService.findAll() ;
            if (myResponseDto==null)
                return createCollectionResponse(500 , "Pogetti non recuperati " , null) ;
            else
                return createCollectionResponse(200, "Pogetti recuperati correttamente", myResponseDto);


        }


        //ADD DELETE

    @PostMapping(RestResources.SAVE)
    RestResponse<ProjectDto> save (@RequestBody Project project ) {
        try {
            projectService.save(project);
            return createResponse(200 ,"salvato correttamente" , null );
        }
        catch (TimesheetException e){
            return createResponse(500,"non salvato" , null );
        }







    }

}


