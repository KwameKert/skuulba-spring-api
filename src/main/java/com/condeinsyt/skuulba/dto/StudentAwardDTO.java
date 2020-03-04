package com.condeinsyt.skuulba.dto;


import com.condeinsyt.skuulba.model.StudentAward;

import java.util.ArrayList;

public class StudentAwardDTO {

    private ArrayList<StudentAward> awards;




    public ArrayList<StudentAward> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<StudentAward> awards) {
        this.awards = awards;
    }
}
