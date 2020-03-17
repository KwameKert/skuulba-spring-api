package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.InvoiceDTO;
import com.condeinsyt.skuulba.service.impl.InvoiceFeeServiceImpl;
import com.condeinsyt.skuulba.service.interfaces.InvoiceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

@RequestMapping("api/v1/finance/invoice/")
public class InvoiceController {

    private InvoiceFeeService invoiceFeeService;

    @Autowired
    public InvoiceController(InvoiceFeeService invoiceFeeService) {
        this.invoiceFeeService = invoiceFeeService;
    }


    @PostMapping
    public ResponseEntity<?> payStudentFee(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        //System.out.println(studentPhysical.length);
        return new ResponseEntity<>(invoiceFeeService.createInvoice(invoiceDTO), HttpStatus.OK);
    }






}
