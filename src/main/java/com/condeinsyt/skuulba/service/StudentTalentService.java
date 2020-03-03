package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentTalentsDTO;
import com.condeinsyt.skuulba.model.StudentTalent;

import java.util.HashMap;

public interface StudentTalentService {


    HashMap<String, Object> createTalent(StudentTalentsDTO studentTalentsDTO);
    HashMap<String, Object> updateTalent(StudentTalent studentTalent);
    HashMap<String, Object> deleteTalent(Long id);
    HashMap<String, Object> listStudentTalent(Long id);
    HashMap<String, Object> findStudentTalentById(Long id);

}
