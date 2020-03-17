package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.dto.StudentAttendanceDTO;
import com.condeinsyt.skuulba.service.interfaces.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student/attendance/")
public class StudentAttendanceController {

    private StudentAttendanceService studentAttendanceService;


    @Autowired
    public StudentAttendanceController(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }

    @PostMapping
    public ResponseEntity<?> addAttendance(@Valid @RequestBody StudentAttendanceDTO studentAttendanceDTO) {
        return new ResponseEntity<>(studentAttendanceService.takeAttendance(studentAttendanceDTO), HttpStatus.OK);
    }


}
