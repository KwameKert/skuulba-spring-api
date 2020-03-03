package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.StudentHealth;

import java.util.HashMap;

public interface StudentHealthService  {

    HashMap<String, Object> createHealth(StudentHealth studentHealth);
    HashMap<String, Object> updateHealth(StudentHealth studentHealth);
    HashMap<String, Object> findHealthByStudentId(Long id);
    HashMap<String, Object> findStudentHealth(Long id);
    HashMap<String, Object> deleteStudentHealth(Long id);


}
