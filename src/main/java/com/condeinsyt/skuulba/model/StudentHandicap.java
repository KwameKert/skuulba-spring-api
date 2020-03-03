package com.condeinsyt.skuulba.model;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_handicap")
public class StudentHandicap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String handicapPart;
    private String handicapDescription;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private  Date updatedAt;

    public StudentHandicap() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHandicapPart() {
        return handicapPart;
    }

    public void setHandicapPart(String handicapPart) {
        this.handicapPart = handicapPart;
    }

    public String getHandicapDescription() {
        return handicapDescription;
    }

    public void setHandicapDescription(String handicapDescription) {
        this.handicapDescription = handicapDescription;
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
        return "StudentHandicap{" +
                "id=" + id +
                ", handicapPart='" + handicapPart + '\'' +
                ", handicapDescription='" + handicapDescription + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
