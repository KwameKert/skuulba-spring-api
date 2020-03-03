package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.StudentHandicap;

import java.util.ArrayList;

public class StudentHandicapDTO {


    private ArrayList<StudentHandicap> handicaps;

    public StudentHandicapDTO() {
    }

    public ArrayList<StudentHandicap> getHandicaps() {
        return handicaps;
    }

    public void setHandicaps(ArrayList<StudentHandicap> handicaps) {
        this.handicaps = handicaps;
    }
}
