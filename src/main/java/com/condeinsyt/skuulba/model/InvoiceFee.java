package com.condeinsyt.skuulba.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="app_invoice_fee")
public class InvoiceFee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Date billDate;
    private Date billDueDate;
    private int amount;
    private String status;
    private Blob notes;
    private Blob terms;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<InvoiceItem> invoiceItems;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
