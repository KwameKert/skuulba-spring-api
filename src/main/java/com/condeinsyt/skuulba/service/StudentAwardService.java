package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentAwardDTO;
import com.condeinsyt.skuulba.model.StudentAward;

import java.util.HashMap;

public interface StudentAwardService {
    HashMap<String, Object> createAward(StudentAwardDTO studentAwardDTO);
    HashMap<String, Object> updateAward(StudentAward studentAward);
    HashMap<String, Object> deleteAward(Long id);
    HashMap<String, Object> listStudentAward(Long id);
    HashMap<String, Object> findStudentAwardById(Long id);
}
