package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.StudentEducationDTO;
import com.condeinsyt.skuulba.service.StudentEducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentEducation/")
public class StudentEducationController {

    private StudentEducationService studentEducationService;

    public StudentEducationController(StudentEducationService studentEducationService){
        this.studentEducationService = studentEducationService;
    }


    @PostMapping
    public ResponseEntity<?> addEducation(@Valid @RequestBody StudentEducationDTO studentEducationDTO) {
        return new ResponseEntity<>(studentEducationService.createEducation(studentEducationDTO), HttpStatus.OK);
    }



}
