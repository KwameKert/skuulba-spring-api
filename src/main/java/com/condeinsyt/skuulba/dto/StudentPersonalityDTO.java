package com.condeinsyt.skuulba.dto;


import com.condeinsyt.skuulba.model.StudentPersonality;

import java.util.ArrayList;

public class StudentPersonalityDTO {


    private ArrayList<StudentPersonality>  personalities;


    public ArrayList<StudentPersonality> getPersonalities() {
        return personalities;
    }

    public void setPersonalities(ArrayList<StudentPersonality> personalities) {
        this.personalities = personalities;
    }
}
