package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.DailyFeeDTO;
import com.condeinsyt.skuulba.service.interfaces.DailyFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/finance/dailyFee/")
public class DailyFeeController {

    private DailyFeeService dailyFeeService;

    @Autowired
    public DailyFeeController(DailyFeeService dailyFeeService) {
        this.dailyFeeService = dailyFeeService;
    }

    @PostMapping
    public ResponseEntity<?> takeFee(@Valid @RequestBody DailyFeeDTO dailyFeeDTO ) {
        return new ResponseEntity<>(dailyFeeService.addFee(dailyFeeDTO), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> listFee() {
        return new ResponseEntity<>(dailyFeeService.listFees(), HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> listStudentDailyFee(@PathVariable("id") Long id){
        return new ResponseEntity<>(dailyFeeService.listStudentDailyFee(id), HttpStatus.OK);

    }





}
