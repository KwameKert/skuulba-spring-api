package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.StudentAwardDTO;
import com.condeinsyt.skuulba.model.StudentAward;
import com.condeinsyt.skuulba.service.interfaces.StudentAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentAward/")
public class StudentAwardController {

    private StudentAwardService studentAwardService;

    @Autowired
    public StudentAwardController(StudentAwardService studentAwardService) {
        this.studentAwardService = studentAwardService;
    }


    @PostMapping
    public ResponseEntity<?> addAward(@RequestBody StudentAwardDTO studentAwardDTO) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(studentAwardService.createAward(studentAwardDTO), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getStudentAward(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentAwardService.listStudentAward(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudentAward(@Valid @RequestBody StudentAward studentAward) {
        return new ResponseEntity<>(studentAwardService.updateAward(studentAward), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAward(@PathVariable("id") long id){
        return new ResponseEntity<>(studentAwardService.deleteAward(id),HttpStatus.OK);
    }

}
