package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.SchoolFeeDTO;
import com.condeinsyt.skuulba.dto.SearchDTO;
import com.condeinsyt.skuulba.model.SchoolFee;

import java.util.HashMap;

public interface SchoolFeeService {

    HashMap<String, Object> paySchoolFee(SchoolFeeDTO schoolFee);

    HashMap<String, Object> listSchoolFee();

    HashMap<String, Object> listSchoolFeeByStudentClass(SearchDTO studentClass);

    HashMap<String, Object> listSchoolFeeByFullName(String name);
}
