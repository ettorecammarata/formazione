package com.besidetech.training.controller;

import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.model.Charge;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.UserDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/charge")
public class ChargeController extends AbstractResponse<ChargeDto>{

    @Autowired
    ChargeService chargeService ;

    @GetMapping("/getAll")
    RestCollectionResponse<ChargeDto> getAllCharge () {
        Set<ChargeDto> myResponse = chargeService.getAll() ;
        if(myResponse==null)
            return createCollectionResponse(502 , "Charge non trovati " , null) ;
        if (myResponse.isEmpty()  )
            return createCollectionResponse(500 , "Charge non recuperati " , null) ;
        else
            return createCollectionResponse(200 , "Charge recuperati correttamente" , myResponse) ;
    }

    @GetMapping ("/find/{id}")
    RestResponse<ChargeDto> findId (@PathVariable("id") Integer id ){
        ChargeDto myChargeDto = chargeService.findById(id) ;
        if (myChargeDto==null)
            return createResponse(500 , "Charge {"+ id + "} non trovato " , null ) ;
        else
            return createResponse(200 , "Charge recuperato correttamente" ,myChargeDto   ) ;

    }

    @RequestMapping ("/save")
    RestResponse<ChargeDto> save (@RequestBody ChargeDto charge) {
        try{
            chargeService.save(charge);
            return createResponse(200 , "Charge salvato con successo" , charge ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @DeleteMapping("/delete/{id}")
    RestResponse<ChargeDto> delete(@PathVariable("id") Integer id){
        try {
            chargeService.delete(id);
            return createResponse(200 , "Charge eliminato " , null ) ;
        }catch (TimesheetException e ) {
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @RequestMapping("/update/{charge}")
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



//    public void save ( List<Charge> charge) ;
//    public void delete(Charge charge) throws ChargeNotFoundException;
//
}
