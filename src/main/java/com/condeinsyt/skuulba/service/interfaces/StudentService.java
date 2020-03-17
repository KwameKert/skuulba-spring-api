package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.dto.SearchDTO;
import com.condeinsyt.skuulba.model.Student;

import java.util.HashMap;
import java.util.Optional;

public interface StudentService {

    HashMap<String, Object> createStudent(Student student);

    HashMap<String, Object> updateStudent(Student student);

    HashMap<String, Object> listStudents();

    HashMap<String, Object>  findStudentById(Long studId);

    HashMap<String, Object> deleteStudent(Long studId);
    HashMap<String, Object> getStudentDetails(Long id);
    HashMap<String, Object> searchStudentDetails(SearchDTO  value);
    HashMap<String, Object> getStudentByClass(SearchDTO  value);

    HashMap<String , Object> getStudentFinance(SearchDTO value);
}
