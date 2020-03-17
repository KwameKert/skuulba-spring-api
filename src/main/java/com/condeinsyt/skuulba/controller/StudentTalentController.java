package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.StudentTalentsDTO;
import com.condeinsyt.skuulba.model.StudentTalent;
import com.condeinsyt.skuulba.service.interfaces.StudentTalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentTalent/")
public class StudentTalentController {


    private StudentTalentService studentTalentService;

    @Autowired
    public StudentTalentController(StudentTalentService studentTalentService) {
        this.studentTalentService = studentTalentService;
    }


    @PostMapping
    public ResponseEntity<?> addTalent(@RequestBody StudentTalentsDTO studentTalentsDTO) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(studentTalentService.createTalent(studentTalentsDTO), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getStudentTalent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentTalentService.listStudentTalent(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudentTalent(@Valid @RequestBody StudentTalent studentTalent) {
        return new ResponseEntity<>(studentTalentService.updateTalent(studentTalent), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTalent(@PathVariable("id") long id){
        return new ResponseEntity<>(studentTalentService.deleteTalent(id),HttpStatus.OK);
    }



}
