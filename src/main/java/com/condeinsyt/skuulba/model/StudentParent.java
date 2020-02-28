package com.condeinsyt.skuulba.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_parent")
public class StudentParent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String fullName;
    private String address;
    private String email;
    private String relation;
    private String occupation;
    private String phoneNumber;
    private String educationStatus;
    private String religion;
    private int numSpouse;
    private String spouseDeceased;
    private Date spouseDeceasedDeceased;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "StudentParent{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", relation='" + relation + '\'' +
                ", occupation='" + occupation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", educationStatus='" + educationStatus + '\'' +
                ", religion='" + religion + '\'' +
                ", numSpouse=" + numSpouse +
                ", spouseDeceased='" + spouseDeceased + '\'' +
                ", spouseDeceasedDeceased=" + spouseDeceasedDeceased +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getNumSpouse() {
        return numSpouse;
    }

    public void setNumSpouse(int numSpouse) {
        this.numSpouse = numSpouse;
    }

    public String getSpouseDeceased() {
        return spouseDeceased;
    }

    public void setSpouseDeceased(String spouseDeceased) {
        this.spouseDeceased = spouseDeceased;
    }

    public Date getSpouseDeceasedDeceased() {
        return spouseDeceasedDeceased;
    }

    public void setSpouseDeceasedDeceased(Date spouseDeceasedDeceased) {
        this.spouseDeceasedDeceased = spouseDeceasedDeceased;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
