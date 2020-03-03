package com.condeinsyt.skuulba.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_student_health")
public class StudentHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String primaryCarePhysician;
    private String pcpNumber;
    private String insuranceNumber;
    private String preferredMedicalFacility;
    private String policyHolderName;
    private String insuranceName;
    private String policyNumber;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;


    public StudentHealth() {
    }

    public StudentHealth(Long studentId, String primaryCarePhysician, String pcpNumber, String insuranceNumber, String preferredMedicalFacility, String policyHolderName, String insuranceName, String policyNumber, Date createdAt, Date updatedAt) {
        this.studentId = studentId;
        this.primaryCarePhysician = primaryCarePhysician;
        this.pcpNumber = pcpNumber;
        this.insuranceNumber = insuranceNumber;
        this.preferredMedicalFacility = preferredMedicalFacility;
        this.policyHolderName = policyHolderName;
        this.insuranceName = insuranceName;
        this.policyNumber = policyNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getPrimaryCarePhysician() {
        return primaryCarePhysician;
    }

    public void setPrimaryCarePhysician(String primaryCarePhysician) {
        this.primaryCarePhysician = primaryCarePhysician;
    }

    public String getPcpNumber() {
        return pcpNumber;
    }

    public void setPcpNumber(String pcpNumber) {
        this.pcpNumber = pcpNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getPreferredMedicalFacility() {
        return preferredMedicalFacility;
    }

    public void setPreferredMedicalFacility(String preferredMedicalFacility) {
        this.preferredMedicalFacility = preferredMedicalFacility;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
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
