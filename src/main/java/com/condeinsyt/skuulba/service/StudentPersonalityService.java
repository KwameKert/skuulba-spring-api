package com.condeinsyt.skuulba.service;


import com.condeinsyt.skuulba.dto.StudentPersonalityDTO;
import com.condeinsyt.skuulba.model.StudentPersonality;

import java.util.HashMap;

public interface StudentPersonalityService  {

     HashMap<String, Object> createPersonality(StudentPersonalityDTO studentPersonalityDTO);
     HashMap<String, Object> updatePersonality(StudentPersonality studentPersonality);
     HashMap<String, Object> deletePersonality(Long id);
    HashMap<String, Object> listStudentPersonality(Long id);
    HashMap<String, Object> findStudentPersonalityById(Long id);
}
