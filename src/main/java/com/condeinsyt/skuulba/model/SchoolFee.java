package com.condeinsyt.skuulba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="app_student_school_fees")
public class SchoolFee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;
    private String fullName;
    private String studentClass;
    private String gender;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    public String getFullName() {
        return StringUtils.capitalize(student.getLastName()) + " " + StringUtils.capitalize(student.getOtherNames());
    }


    public String getStudentClass() {
        return StringUtils.capitalize(student.getStudentClass());
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public String getGender() {
        return student.getGender();
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

    @JsonIgnore
    public Student getStudent() {
        return student;
    }
    @JsonIgnore
    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "SchoolFee{" +
                "id=" + id +
                ", amount=" + amount +
                ", fullName='" + fullName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", gender='" + gender + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", student=" + student +
                '}';
    }
}
