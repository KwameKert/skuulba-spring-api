package com.condeinsyt.skuulba.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_daily_fees")
public class DailyFees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


    private String type;
    private int amount;
    private String fullName;
    private String gender;
    private String studentClass;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return student.getGender();
    }

    public String getFullName() {
        return student.getLastName().toUpperCase()+ " "+ student.getOtherNames().toUpperCase();
    }



    public String getStudentClass() {
        return student.getStudentClass().toUpperCase();
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @JsonIgnore
    public Student getStudent() {
        return student;
    }

    @JsonIgnore
    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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


    @Override
    public String toString() {
        return "DailyFees{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
