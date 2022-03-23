package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.ChargeMap;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.ChargeService;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(RestResources.REST_CHARGE)
public class ChargeController extends AbstractResponse<ChargeDto>{

    @Autowired
    ChargeService chargeService ;

    @GetMapping (RestResources.FIND+RestResources.ID)
    RestResponse<ChargeDto> findId (@PathVariable("id") Integer id ){
        ChargeDto myChargeDto = chargeService.findById(id) ;
        if (myChargeDto==null)
            return createResponse(500 , "Charge {"+ id + "} non trovato " , null ) ;
        else
            return createResponse(200 , "Charge recuperato correttamente" ,myChargeDto   ) ;

    }

    @PostMapping (RestResources.SAVE)
    RestResponse<ChargeDto> save ( @Valid @RequestBody ChargeDto charge ,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println("binding result : " +  bindingResult.getFieldError().getDefaultMessage());
            return createResponse(500 , "errore sul campo "+bindingResult.getFieldError() , null ) ;
        }
        try{
            chargeService.save(charge);
            return createResponse(200 , "Charge salvato con successo" , null ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @RequestMapping(RestResources.UPDATE+RestResources.ID)
    RestResponse<ChargeDto> update (@RequestBody ChargeDto charge)  throws TimesheetException{
        ChargeDto tmp = chargeService.findById(charge.getId()) ;
        charge.setId(tmp.getId());
        try {
            chargeService.save(charge);
            return createResponse(200 , "charge aggiornato correttamente " , charge) ;
        }catch ( TimesheetException f ) {
            return createResponse(500 , "charge non aggiornato " , null ) ;
        }
    }

    @DeleteMapping(RestResources.DELETE)
    RestResponse<ChargeDto> delete (@RequestBody ChargeDto charge ) {
        try{
            chargeService.delete(charge);
            return createResponse(200 , "Charge cancellato con successo" , null ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }


    @PostMapping(RestResources.SAVE_ALL)
    public RestCollectionResponse<ChargeDto> saveAll (@RequestBody Map<Integer , List<ChargeDto>> charges ) {
        try {
            chargeService.saveAll(charges);
            return createCollectionResponse(200 , "inserito charge" , null);
        }catch (Exception e) {
            return createCollectionResponse(500 , e.getMessage() , null );
        }
    }


}
