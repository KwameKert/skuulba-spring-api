package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentPhysicalDTO;
import com.condeinsyt.skuulba.model.ArrayHolder;
import com.condeinsyt.skuulba.model.StudentPhysical;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public interface StudentPhysicalService {

    HashMap<String, Object> createPhysical(StudentPhysicalDTO studentPhysical);
    HashMap<String, Object> updatePhysical(StudentPhysical studentPhysical);
    HashMap<String, Object> deletePhysical(Long id);
    HashMap<String, Object> listStudentPhysical(Long id);
    HashMap<String, Object> findStudentPhysicalById(Long id);


}
