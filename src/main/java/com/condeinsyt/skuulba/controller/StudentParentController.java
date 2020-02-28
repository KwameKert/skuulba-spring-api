package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.model.StudentParent;
import com.condeinsyt.skuulba.service.StudentParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentParent/")
public class StudentParentController {

    private StudentParentService studentParentService;

    @Autowired
    public StudentParentController(StudentParentService studentParentService){
        this.studentParentService = studentParentService;
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentParent studentParent){
        return new ResponseEntity<>(this.studentParentService.createStudentParent(studentParent), HttpStatus.OK);
    }

}
