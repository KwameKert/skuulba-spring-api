package com.condeinsyt.skuulba.dto;

import com.condeinsyt.skuulba.model.InvoiceItem;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceDTO {

    private ArrayList<InvoiceItem> invoiceItems;
    private String type;
    private String value;
    private Date billDate;
    private Date billDueDate;
    private int amount;
    private String status;
    private Blob notes;
    private Blob terms;

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

    public Blob getNotes() {
        return notes;
    }

    public void setNotes(Blob notes) {
        this.notes = notes;
    }

    public Blob getTerms() {
        return terms;
    }

    public void setTerms(Blob terms) {
        this.terms = terms;
    }
}
