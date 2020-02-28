package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.StudentParent;

import java.util.HashMap;

public interface StudentParentService {

    HashMap<String, Object> createStudentParent(StudentParent studentParent);
    HashMap<String, Object> updateStudentParent(StudentParent studentParent);
    HashMap<String, Object> listStudentParent();
    HashMap<String, Object> findStudentParent(Long id);
    HashMap<String, Object> deleteStudentParent(Long id);
}
