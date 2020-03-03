package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.StudentPhysical;

import java.util.ArrayList;
import java.util.Date;

public class StudentPhysicalDTO {


    private ArrayList<StudentPhysical>  physicals;

    public StudentPhysicalDTO() {
    }

    public ArrayList<StudentPhysical> getPhysicals() {
        return physicals;
    }

    public void setPhysicals(ArrayList<StudentPhysical> physicals) {
        this.physicals = physicals;
    }
}
