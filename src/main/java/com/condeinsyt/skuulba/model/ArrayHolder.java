package com.condeinsyt.skuulba.model;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

public class ArrayHolder {

   // private Long studentId;
    private List<?> physicals;

//    public Long getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Long studentId) {
//        this.studentId = studentId;
//    }

    public List<?> getHolder() {
        return physicals;
    }

    public void setHolder(List<String> physicals) {
        this.physicals = physicals;
    }
}
