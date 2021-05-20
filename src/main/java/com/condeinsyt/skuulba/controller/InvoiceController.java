package com.condeinsyt.skuulba.controller;


import com.condeinsyt.skuulba.dto.InvoiceDTO;
import com.condeinsyt.skuulba.service.impl.InvoiceFeeServiceImpl;
import com.condeinsyt.skuulba.service.interfaces.InvoiceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> generateInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {

        return new ResponseEntity<>(invoiceFeeService.createInvoice(invoiceDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listInvoices(){
        return new ResponseEntity<>(invoiceFeeService.listInvoice(),HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getInvoice(@Valid  @PathVariable("id") Long id){
        return new ResponseEntity<>(invoiceFeeService.getInvoice(id),HttpStatus.OK);
    }


//
//    @GetMapping("student/{id}")
//    public ResponseEntity<?> listStudentInvoice(@PathVariable("id") Long id){
//        return new ResponseEntity<>(invoiceFeeService.listStudentDailyFee(id), HttpStatus.OK);
//
//    }





}
