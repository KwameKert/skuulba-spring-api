package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.Student;

import java.util.ArrayList;

public class StudentAttendanceDTO {

    private ArrayList<Student> students;


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
