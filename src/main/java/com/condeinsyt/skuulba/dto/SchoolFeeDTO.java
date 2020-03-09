package com.condeinsyt.skuulba.dto;

public class SchoolFeeDTO {

    private Long studentId;

    private int amount;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
