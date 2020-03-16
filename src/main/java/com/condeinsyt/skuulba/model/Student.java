package com.condeinsyt.skuulba.model;


import com.condeinsyt.skuulba.utils.AgeCalculator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private String status;
    private String studentClass;
    private String[] languages;
    private String religion;
    private String gender;
    private int age;

    private String image_url;
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<SchoolFee> schoolFees;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DailyFees> dailyFees;


    public Student() {
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DailyFees> getDailyFees() {
        return dailyFees;
    }

    public void setDailyFees(List<DailyFees> dailyFees) {
        this.dailyFees = dailyFees;
    }

    public List<SchoolFee> getSchoolFees() {
        return schoolFees;
    }

    public void setSchoolFees(List<SchoolFee> schoolFees) {
        this.schoolFees = schoolFees;
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
        return studentClass.toUpperCase();
    }

    public int getAge() {
        return AgeCalculator.calculateAge(dob, new Date());

    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass.toLowerCase();
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
        return lastName.toUpperCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }

    public String getReligion() {
        return religion.toUpperCase();
    }

    public void setReligion(String religion) {
        this.religion = religion.toLowerCase();
    }

    public String getGender() {
        return gender.toUpperCase();
    }

    public void setGender(String gender) {
        this.gender = gender.toLowerCase();
    }

    public String getOtherNames() {
        return otherNames.toUpperCase();
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames.toLowerCase();
    }

    public String getMotherTongue() {
        return motherTongue.toUpperCase();
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue.toLowerCase();
    }

    public String getHomeTown() {
        return homeTown.toLowerCase();
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown.toLowerCase();
    }

    public String getLivingWith() {
        return livingWith.toUpperCase();
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
