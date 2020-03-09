package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.SchoolFee;
import com.condeinsyt.skuulba.model.Student;

import java.util.Date;

public class StudentSchoolFeeHolder {

    //private SchoolFeeDTO;
    //private StudentDTO;
    private String fullName;
    private String studentClass;
    private Date createdAt;
    private int amount;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
