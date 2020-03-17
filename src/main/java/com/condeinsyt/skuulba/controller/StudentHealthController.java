package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.model.StudentHealth;
import com.condeinsyt.skuulba.service.interfaces.StudentHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentHealth/")
public class StudentHealthController {

    private StudentHealthService studentHealthService;

    @Autowired
    public StudentHealthController(StudentHealthService studentHealthService) {
        this.studentHealthService = studentHealthService;
    }

    @PostMapping
    public ResponseEntity<?> addPersonality(@RequestBody StudentHealth studentHealth) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(studentHealthService.createHealth(studentHealth), HttpStatus.OK);
    }




    @GetMapping("student/{id}")
    public ResponseEntity<?> getStudentHealth(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentHealthService.findHealthByStudentId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePersonality(@Valid @RequestBody StudentHealth studentHealth) {
        return new ResponseEntity<>(studentHealthService.updateHealth(studentHealth), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersonality(@PathVariable("id") long id){
        return new ResponseEntity<>(studentHealthService.deleteStudentHealth(id),HttpStatus.OK);
    }


}
