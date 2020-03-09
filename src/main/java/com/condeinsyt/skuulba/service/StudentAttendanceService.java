package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentAttendanceDTO;
import com.condeinsyt.skuulba.model.Student;

import java.util.HashMap;

public interface StudentAttendanceService {

    HashMap<String , Object> takeAttendance(StudentAttendanceDTO students);

    HashMap<String, Object> getClassAttendance(String studentClass);
}
