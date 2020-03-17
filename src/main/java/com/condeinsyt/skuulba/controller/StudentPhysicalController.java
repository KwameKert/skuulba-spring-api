package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.StudentPhysicalDTO;
import com.condeinsyt.skuulba.model.StudentPhysical;
import com.condeinsyt.skuulba.service.interfaces.StudentPhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/studentPhysical/")
public class StudentPhysicalController {

    private StudentPhysicalService studentPhysicalService;

    @Autowired
    public StudentPhysicalController(StudentPhysicalService studentPhysicalService){
        this.studentPhysicalService = studentPhysicalService;
    }


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody StudentPhysicalDTO studentPhysical) {
        //System.out.println(studentPhysical.length);
       return new ResponseEntity<>(studentPhysicalService.createPhysical(studentPhysical), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getStudentPhysical(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentPhysicalService.listStudentPhysical(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody StudentPhysical studentPhysical) {
        return new ResponseEntity<>(studentPhysicalService.updatePhysical(studentPhysical), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        return new ResponseEntity<>(studentPhysicalService.deletePhysical(id),HttpStatus.OK);
    }

}
