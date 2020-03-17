package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.SchoolFeeDTO;
import com.condeinsyt.skuulba.service.interfaces.SchoolFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/finance/schoolFee/")
public class SchoolFeeController {

    private SchoolFeeService schoolFeeService;

    @Autowired
    public SchoolFeeController(SchoolFeeService schoolFeeService) {
        this.schoolFeeService = schoolFeeService;
    }


    @PostMapping
    public ResponseEntity<?> payStudentFee(@Valid @RequestBody SchoolFeeDTO schoolFeeDTO) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(schoolFeeService.paySchoolFee(schoolFeeDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listSchoolFee() {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(schoolFeeService.listSchoolFee(), HttpStatus.OK);
    }

//    @PostMapping("search/")
//    public ResponseEntity<?> listSchoolFeeByStudentId(@Valid @RequestBody SearchDTO searchDTO) {
//        //System.out.println(studentPhysical.length);
//        return new ResponseEntity<>(schoolFeeService.listSchoolFeeByStudentClass(searchDTO), HttpStatus.OK);
//    }




}
