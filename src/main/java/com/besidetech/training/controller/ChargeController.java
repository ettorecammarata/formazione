package com.besidetech.training.controller;

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

    @GetMapping (RestResources.FIND+RestResources.ID)
    RestResponse<ChargeDto> findId (@PathVariable("id") Integer id ){
        ChargeDto myChargeDto = chargeService.findById(id) ;
        if (myChargeDto==null)
            return createResponse(500 , AbstractResponse.CHARGE_NOT_FOUND , null ) ;
        else
            return createResponse(200 , AbstractResponse.CHARGE_IDENTIFIED ,myChargeDto   ) ;
    }

    @PostMapping (RestResources.SAVE)
    RestResponse<ChargeDto> save ( @Valid @RequestBody ChargeDto charge ,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(AbstractResponse.BINDIG_RESULT +  bindingResult.getFieldError().getDefaultMessage());
            return createResponse(500 , AbstractResponse.ERROR_IN_FIELD + bindingResult.getFieldError() , null ) ;
        }
        try{
            chargeService.save(charge);
            return createResponse(200 , SAVED_CHARGE , null ) ;
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
            return createResponse(200 , AbstractResponse.CHARGE_UPDATED , charge) ;
        }catch ( TimesheetException f ) {
            return createResponse(500 , AbstractResponse.CHARGE_NOT_UPDATED , null ) ;
        }
    }

    @DeleteMapping(RestResources.DELETE)
    RestResponse<ChargeDto> delete (@RequestBody ChargeDto charge ) {
        try{
            chargeService.delete(charge);
            return createResponse(200 , CHARGE_DELETED, null ) ;
        }catch (TimesheetException e ){
            return createResponse(500 , e.getMessage() , null ) ;
        }
    }

    @PostMapping(RestResources.SAVE_ALL)
    public RestCollectionResponse<ChargeDto> saveAll (@RequestBody Map<Integer , List<ChargeDto>> charges ) {
        try {
            chargeService.saveAll(charges);
            return createCollectionResponse(200 , CHARGE_SAVED, null);
        }catch (Exception e) {
            return createCollectionResponse(500 , e.getMessage() , null );
        }
    }

    @GetMapping (RestResources.GET_MONTH)
    public RestCollectionResponse<ChargeDto> getMonthCharge (@RequestBody ExactMothDateDto current ) {
        try {
            List<ChargeDto> tmp = chargeService.findAndSortByDate(current) ;
            return createCollectionResponse(200 , LIST_OF_CHARGE , tmp.stream().collect(Collectors.toSet()) );
        }catch (TimesheetException e) {
            return createCollectionResponse(500, e.getMessage(), null);
        }
    }

    @GetMapping (RestResources.GET_MONTH + "/my")
    public RestCollectionResponse<ChargeDto> getDateCharge (@RequestBody RequestChargeDto current ) {
        try {
            Set<ChargeDto> tmp = chargeService.findSortedCharge(current) ;
            return createCollectionResponse(200 , LIST_OF_CHARGE, tmp );
        }catch (TimesheetException e) {
            return createCollectionResponse(500, e.getMessage(), null);
        }
    }

    @GetMapping (RestResources.GET_TIMESHEET)
    public  RestCollectionResponse<ChargeDto> getTimesheet (@RequestBody RequestChargeDto requestChargeDto) {
        try {
            MyTimesheetDto response = chargeService.getTimesheetDto(requestChargeDto) ;
            return createCollectionResponse(200 , GET_TIMESHEET , null ) ;
        }catch (Exception e ) {
            return createCollectionResponse(500 ,  FAILED_GET_TIMESHEET , null ) ;
        }
    }

}
