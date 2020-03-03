package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.StudentPersonalityDTO;
import com.condeinsyt.skuulba.model.StudentPersonality;
import com.condeinsyt.skuulba.service.StudentPersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentPersonality/")
public class StudentPersonalityController {

    private StudentPersonalityService studentPersonalityService;

    @Autowired
    public StudentPersonalityController(StudentPersonalityService studentPersonalityService){
        this.studentPersonalityService = studentPersonalityService;
    }

    @PostMapping
    public ResponseEntity<?> addPersonality(@RequestBody StudentPersonalityDTO studentPhysical) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(studentPersonalityService.createPersonality(studentPhysical), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getStudentPersonality(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentPersonalityService.listStudentPersonality(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePersonality(@Valid @RequestBody StudentPersonality studentPhysical) {
        return new ResponseEntity<>(studentPersonalityService.updatePersonality(studentPhysical), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersonality(@PathVariable("id") long id){
        return new ResponseEntity<>(studentPersonalityService.deletePersonality(id),HttpStatus.OK);
    }



}
