package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.SearchDTO;
import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        return new ResponseEntity<>(this.studentService.createStudent(student), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getStudent(@Valid @PathVariable("id") Long id){
        return new ResponseEntity<>(this.studentService.findStudentById(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(this.studentService.listStudents(), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student){

        return new ResponseEntity<>(this.studentService.updateStudent(student), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
      return new ResponseEntity<>(this.studentService.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("studentDetails/{id}")
    public ResponseEntity<?> getStudentDetails(@PathVariable("id") Long id){

        return new ResponseEntity<>(this.studentService.getStudentDetails(id),HttpStatus.OK);
    }


    @PostMapping("search")
    public ResponseEntity<?> getStudentSearch(@RequestBody SearchDTO values){
        return new ResponseEntity<>(this.studentService.searchStudentDetails(values), HttpStatus.OK);
    }

    @PostMapping("class/")
    public ResponseEntity<?> getClass(@RequestBody SearchDTO value){
        return new ResponseEntity<>(this.studentService.getStudentByClass(value), HttpStatus.OK);
    }


    @PostMapping("/paramsearch/")
    public ResponseEntity<?> searchStudentFinance(@RequestBody SearchDTO value){
        return new ResponseEntity<>(this.studentService.getStudentFinance(value), HttpStatus.OK);
    }



}
