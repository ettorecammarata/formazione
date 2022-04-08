package com.besidetech.training.controller;

import com.besidetech.training.controller.logger.LoggingController;
import com.besidetech.training.exception.TimesheetException;
import com.besidetech.training.modelDto.ExactMothDateDto;
import com.besidetech.training.modelDto.ChargeDto;
import com.besidetech.training.modelDto.MyTimesheetDto;
import com.besidetech.training.modelDto.RequestChargeDto;
import com.besidetech.training.restmodel.RestCollectionResponse;
import com.besidetech.training.restmodel.RestResponse;
import com.besidetech.training.restmodel.restresources.RestResources;
import com.besidetech.training.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RestResources.REST_CHARGE)
public class ChargeController extends AbstractResponse<ChargeDto>{

    @Autowired
    ChargeService chargeService ;
    @Autowired
    LoggingController loggingController ;

    @GetMapping (RestResources.FIND+RestResources.ID)
    RestResponse<ChargeDto> findId (@PathVariable("id") Integer id ){
        ChargeDto myChargeDto = chargeService.findById(id) ;
        if (myChargeDto==null){
            loggingController.info(AbstractResponse.CHARGE_NOT_FOUND) ;
            return createResponse(500 , AbstractResponse.CHARGE_NOT_FOUND , null ) ;}
        else{
            loggingController.info(AbstractResponse.CHARGE_GET) ;
            return createResponse(200 , AbstractResponse.CHARGE_GET,myChargeDto   ) ;
        }
    }

    @PostMapping (RestResources.SAVE)
    RestResponse<ChargeDto> save ( @Valid @RequestBody ChargeDto charge ,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            System.err.println(AbstractResponse.BINDIG_RESULT +  bindingResult.getFieldError().getDefaultMessage());
            loggingController.info(AbstractResponse.BINDIG_RESULT +  bindingResult.getFieldError().getDefaultMessage()) ;
            return createResponse(500 , AbstractResponse.ERROR_IN_FIELD + bindingResult.getFieldError() , null ) ;
        }
        try{
            chargeService.save(charge);
            loggingController.info(AbstractResponse.CHARGE_SAVE) ;
            return createResponse(200 , CHARGE_SAVE, null ) ;
        }catch (TimesheetException e ){
            loggingController.info(e.getMessage()) ;
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @RequestMapping(RestResources.UPDATE+RestResources.ID)
    RestResponse<ChargeDto> update (@RequestBody ChargeDto charge)  throws TimesheetException{
        ChargeDto tmp = chargeService.findById(charge.getId()) ;
        charge.setId(tmp.getId());
        try {
            chargeService.save(charge);
            loggingController.info(AbstractResponse.CHARGE_UPDATE) ;
            return createResponse(200 , AbstractResponse.CHARGE_UPDATE, charge) ;
        }catch ( TimesheetException f ) {
            loggingController.info(AbstractResponse.CHARGE_FAILED_UPDATE) ;
            return createResponse(500 , AbstractResponse.CHARGE_FAILED_UPDATE, null ) ;
        }
    }

    @DeleteMapping(RestResources.DELETE)
    RestResponse<ChargeDto> delete (@RequestBody ChargeDto charge ) {
        try{
            chargeService.delete(charge);
            loggingController.info(AbstractResponse.CHARGE_DELETE) ;
            return createResponse(200 , CHARGE_DELETE, null ) ;
        }catch (TimesheetException e ){
            loggingController.info(e.getMessage()) ;
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @PostMapping(RestResources.SAVE_ALL)
    public RestCollectionResponse<ChargeDto> saveAll (@RequestBody Map<Integer , List<ChargeDto>> charges ) {
        try {
            chargeService.saveAll(charges);
            loggingController.info(AbstractResponse.CHARGE_GET_LIST) ;
            return createCollectionResponse(200 , AbstractResponse.CHARGE_SAVED, null);
        }catch (Exception e) {
            loggingController.info(e.getMessage()) ;
            return createCollectionResponse(500 , e.getMessage() , null );
        }
    }

    //Questo metodo è da cancellare
//    @GetMapping (RestResources.GET_MONTH)
//    public RestCollectionResponse<ChargeDto> getMonthCharge (@RequestBody ExactMothDateDto current ) {
//        try {
//            List<ChargeDto> tmp = chargeService.findAndSortByDate(current) ;
//            return createCollectionResponse(200 , CHARGE_GET_LIST, tmp.stream().collect(Collectors.toSet()) );
//        }catch (TimesheetException e) {
//            return createCollectionResponse(500, e.getMessage(), null);
//        }
//    }

    @GetMapping (value = RestResources.GET_MONTH  ,  produces= MediaType.APPLICATION_JSON_VALUE )
    public RestCollectionResponse<ChargeDto> getDateCharge (@RequestBody RequestChargeDto current ) {
        try {
            Set<ChargeDto> tmp = chargeService.findSortedCharge(current) ;
            loggingController.info(AbstractResponse.CHARGE_GET_LIST) ;
            return createCollectionResponse(200 , AbstractResponse.CHARGE_GET_LIST, tmp );
        }catch (TimesheetException e) {
            loggingController.info(e.getMessage()) ;
            return createCollectionResponse(500, e.getMessage(), null);
        }
    }

    @GetMapping (RestResources.GET_TIMESHEET)
    public  RestCollectionResponse<ChargeDto> getTimesheet (@RequestBody RequestChargeDto requestChargeDto) {
        try {
            MyTimesheetDto response = chargeService.getTimesheetDto(requestChargeDto) ;
            loggingController.info(AbstractResponse.GET_TIMESHEET) ;
            return createCollectionResponse(200 , AbstractResponse.GET_TIMESHEET , null ) ;
        }catch (Exception e ) {
            loggingController.info(AbstractResponse.FAILED_GET_TIMESHEET) ;
            return createCollectionResponse(500 ,  AbstractResponse.FAILED_GET_TIMESHEET , null ) ;
        }
    }

}
