package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentEducationDTO;
import com.condeinsyt.skuulba.model.StudentEducation;

import java.util.HashMap;

public interface StudentEducationService {


    HashMap<String, Object> createEducation(StudentEducationDTO studentEducationDTO);
    HashMap<String, Object> updateEducation(StudentEducation studentEducation);
    HashMap<String, Object> deleteEducation(Long id);
    HashMap<String, Object> listStudentEducation(Long id);
    HashMap<String, Object> findStudentEducationById(Long id);


}
