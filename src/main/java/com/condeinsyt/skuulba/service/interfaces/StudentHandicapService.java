package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.dto.StudentHandicapDTO;
import com.condeinsyt.skuulba.model.StudentHandicap;

import java.util.HashMap;

public interface StudentHandicapService {

    HashMap<String, Object> createHandicap(StudentHandicapDTO studentHandicapDTO);
    HashMap<String, Object> updateHandicap(StudentHandicap studentHandicap);
    HashMap<String, Object> deleteHandicap(Long id);
    HashMap<String, Object> listStudentHandicap(Long id);
    HashMap<String, Object> findStudentHandicapById(Long id);
}
