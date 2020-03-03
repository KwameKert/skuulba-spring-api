package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.StudentTalent;

import java.util.ArrayList;

public class StudentTalentsDTO {


    private ArrayList<StudentTalent> talents;

    public StudentTalentsDTO() {
    }


    public ArrayList<StudentTalent> getTalents() {
        return talents;
    }

    public void setTalents(ArrayList<StudentTalent> talents) {
        this.talents = talents;
    }

    @Override
    public String toString() {
        return "StudentTalentsDTO{" +
                "talents=" + talents +
                '}';
    }
}
