package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.Student;

import java.util.HashMap;

public interface StudentService {

    HashMap<String, Object> createStudent(Student student);

    HashMap<String, Object> updateStudent(Student student);

    HashMap<String, Object> listStudents();

    HashMap<String, Object>  findStudentById(Long studId);

    HashMap<String, Object> deleteStudent(Long studId);
}
