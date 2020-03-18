package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.InvoiceItem;
import com.condeinsyt.skuulba.model.Student;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceDTO {

    private ArrayList<InvoiceItem> invoiceItems;
    private ArrayList<Student> student;
    private String type;
    private String value;
    private Date billDate;
    private Date billDueDate;
    private int amount;
    private String status;
    private String notes;
    private String terms;


    public InvoiceDTO(ArrayList<InvoiceItem> invoiceItems, String type, String value, Date billDate, Date billDueDate, int amount, String status, String notes, String terms) {
        this.invoiceItems = invoiceItems;
        this.type = type;
        this.value = value;
        this.billDate = billDate;
        this.billDueDate = billDueDate;
        this.amount = amount;
        this.status = status;
        this.notes = notes;
        this.terms = terms;
    }

    public InvoiceDTO() {
    }

    public ArrayList<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(ArrayList<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(Date billDueDate) {
        this.billDueDate = billDueDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTerms() {
        return terms;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}
