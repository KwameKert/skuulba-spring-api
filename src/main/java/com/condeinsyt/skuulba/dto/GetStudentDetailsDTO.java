package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.*;

import java.util.List;

public class GetStudentDetailsDTO {

    private Student student;
    private List<StudentParent> studentParent;
    private List<StudentAward> studentAward;
    private List<StudentHandicap> studentHandicap;
    private StudentHealth studentHealth;
    private List<StudentTalent> studentTalent;
    private List<StudentEducation> studentEducation;
    private List<StudentPhysical> studentPhysical;
    private List<StudentPersonality> studentPersonalities;

    public List<StudentPersonality> getStudentPersonalities() {
        return studentPersonalities;
    }

    public void setStudentPersonalities(List<StudentPersonality> studentPersonalities) {
        this.studentPersonalities = studentPersonalities;
    }

    public GetStudentDetailsDTO() {
    }


    public List<StudentPhysical> getStudentPhysical() {
        return studentPhysical;
    }

    public void setStudentPhysical(List<StudentPhysical> studentPhysical) {
        this.studentPhysical = studentPhysical;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentParent> getStudentParent() {
        return studentParent;
    }

    public void setStudentParent(List<StudentParent> studentParent) {
        this.studentParent = studentParent;
    }

    public List<StudentAward> getStudentAward() {
        return studentAward;
    }

    public void setStudentAward( List<StudentAward>  studentAward) {
        this.studentAward = studentAward;
    }

    public List<StudentHandicap> getStudentHandicap() {
        return studentHandicap;
    }

    public void setStudentHandicap(List<StudentHandicap> studentHandicap) {
        this.studentHandicap = studentHandicap;
    }

    public StudentHealth getStudentHealth() {
        return studentHealth;
    }

    public void setStudentHealth(StudentHealth studentHealth) {
        this.studentHealth = studentHealth;
    }

    public List<StudentTalent> getStudentTalent() {
        return studentTalent;
    }

    public void setStudentTalent(List<StudentTalent> studentTalent) {
        this.studentTalent = studentTalent;
    }

    public List<StudentEducation> getStudentEducation() {
        return studentEducation;
    }

    public void setStudentEducation(List<StudentEducation> studentEducation) {
        this.studentEducation = studentEducation;
    }


    @Override
    public String toString() {
        return "GetStudentDetailsDTO{" +
                "student=" + student +
                ", studentParent=" + studentParent +
                ", studentAward=" + studentAward +
                ", studentHandicap=" + studentHandicap +
                ", studentHealth=" + studentHealth +
                ", studentTalent=" + studentTalent +
                ", studentEducation=" + studentEducation +
                '}';
    }
}
