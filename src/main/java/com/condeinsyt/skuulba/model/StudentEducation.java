package com.condeinsyt.skuulba.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_education")
public class StudentEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String schoolName;
    private Date admissionDate;
    private Date lastAdmissionDate;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public StudentEducation() {
    }

    public StudentEducation(Long studentId, String schoolName, Date admissionDate, Date lastAdmissionDate, Date createdAt, Date updatedAt) {
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.admissionDate = admissionDate;
        this.lastAdmissionDate = lastAdmissionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getLastAdmissionDate() {
        return lastAdmissionDate;
    }

    public void setLastAdmissionDate(Date lastAdmissionDate) {
        this.lastAdmissionDate = lastAdmissionDate;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentEducation{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", schoolName='" + schoolName + '\'' +
                ", admissionDate=" + admissionDate +
                ", lastAdmissionDate=" + lastAdmissionDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
