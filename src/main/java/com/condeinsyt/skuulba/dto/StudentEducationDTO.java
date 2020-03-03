package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.StudentEducation;

import java.util.ArrayList;

public class StudentEducationDTO {

    private ArrayList<StudentEducation> educations;

    public StudentEducationDTO() {
    }

    public ArrayList<StudentEducation> getEducations() {
        return educations;
    }

    public void setEducations(ArrayList<StudentEducation> educations) {
        this.educations = educations;
    }
}
