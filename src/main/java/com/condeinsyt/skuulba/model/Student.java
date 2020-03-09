package com.condeinsyt.skuulba.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="app_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    private String lastName;
    private String otherNames;
    private String motherTongue;
    private String homeTown;
    private String livingWith;
    private Integer noSiblings;
    private Date dob;
    private String studentClass;
    private String[] languages;
    private String religion;
    private String gender;

    private String image_url;
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Student() {
    }

    public Student(String lastName, String otherNames, String motherTongue, String homeTown, String livingWith, Integer noSiblings, Date dob, String studentClass, String[] languages, String religion, String gender, String image_url, Date createdAt, Date updatedAt) {
        this.lastName = lastName;
        this.otherNames = otherNames;
        this.motherTongue = motherTongue;
        this.homeTown = homeTown;
        this.livingWith = livingWith;
        this.noSiblings = noSiblings;
        this.dob = dob;
        this.studentClass = studentClass;
        this.languages = languages;
        this.religion = religion;
        this.gender = gender;
        this.image_url = image_url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames.toLowerCase();
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue.toLowerCase();
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown.toLowerCase();
    }

    public String getLivingWith() {
        return livingWith;
    }

    public void setLivingWith(String livingWith) {
        this.livingWith = livingWith.toLowerCase();
    }

    public Integer getNoSiblings() {
        return noSiblings;
    }

    public void setNoSiblings(Integer noSiblings) throws Exception {
        if (noSiblings instanceof Integer ){
            this.noSiblings = noSiblings;
        }else{
            throw new Exception("Invalid Input");
        }

    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", motherTongue='" + motherTongue + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", livingWith='" + livingWith + '\'' +
                ", noSiblings=" + noSiblings +
                ", dob=" + dob +
                ", languages=" + Arrays.toString(languages) +
                ", createdAt=" + createdAt +
                '}';
    }
}
