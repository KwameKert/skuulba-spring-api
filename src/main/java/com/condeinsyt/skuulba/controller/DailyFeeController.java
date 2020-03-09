package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.model.DailyFees;
import com.condeinsyt.skuulba.service.DailyFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> takeFee(@Valid @RequestBody DailyFees dailyFees) {
        return new ResponseEntity<>(dailyFeeService.addFee(dailyFees), HttpStatus.OK);
    }
}
