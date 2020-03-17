package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.StudentHandicapDTO;
import com.condeinsyt.skuulba.model.StudentHandicap;
import com.condeinsyt.skuulba.service.interfaces.StudentHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentHandicap/")
public class StudentHandicapController {


    private StudentHandicapService handicapService;

    @Autowired
    public StudentHandicapController(StudentHandicapService handicapService) {
        this.handicapService = handicapService;
    }


    @PostMapping
    public ResponseEntity<?> addHandicap(@RequestBody StudentHandicapDTO studentHandicapDTO) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(handicapService.createHandicap(studentHandicapDTO), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getStudentHandicap(@PathVariable("id") Long id) {
        return new ResponseEntity<>(handicapService.listStudentHandicap(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateHandicap(@Valid @RequestBody StudentHandicap studentHandicap) {
        return new ResponseEntity<>(handicapService.updateHandicap(studentHandicap), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteHandicap(@PathVariable("id") long id){
        return new ResponseEntity<>(handicapService.deleteHandicap(id),HttpStatus.OK);
    }


}
