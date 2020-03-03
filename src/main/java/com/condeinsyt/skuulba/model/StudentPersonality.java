package com.condeinsyt.skuulba.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_personality")
public class StudentPersonality {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String trait;
    private String studentClass;
    private String remark;
    private int score;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;


    public StudentPersonality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
        return "StudentPersonality{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", trait='" + trait + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", remark='" + remark + '\'' +
                ", score=" + score +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }




}
