package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.model.InvoiceFee;
import com.condeinsyt.skuulba.repository.InvoiceFeeRepository;
import com.condeinsyt.skuulba.service.interfaces.InvoiceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceFeeServiceImpl implements InvoiceFeeService {

    private InvoiceFeeRepository invoiceFeeRepository;

    @Autowired
    public InvoiceFeeServiceImpl(InvoiceFeeRepository invoiceFeeRepository) {
        this.invoiceFeeRepository = invoiceFeeRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }
    @Override
    public HashMap<String, Object> createInvoice(InvoiceFee invoiceFee) {
        try{
            InvoiceFee savedInvoice = this.invoiceFeeRepository.save(invoiceFee);
            return responseAPI(savedInvoice,"Invoice saved successfully",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.NO_CONTENT);
        }

    }

    @Override
    public HashMap<String, Object> updateInvoice(InvoiceFee invoiceFee) {
        try{

            Optional<InvoiceFee> invoice = this.invoiceFeeRepository.findById(invoiceFee.getId());
            if(!invoice.isPresent()){
                return responseAPI(null,"No invoice found",HttpStatus.NO_CONTENT);
            }
            InvoiceFee savedInvoice = this.invoiceFeeRepository.save(invoiceFee);
            return responseAPI(savedInvoice, "Invoice updated successfully",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listInvoice() {
        try{
            List<InvoiceFee> invoices = this.invoiceFeeRepository.findAllByStatusOrderByIdDesc("active");

            if(invoices.isEmpty()){
                return responseAPI(null, "No invoices found",HttpStatus.NO_CONTENT);
            }

            return responseAPI(invoices,"Invoices Found",HttpStatus.OK);
        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> getInvoice(Long id) {
        return null;
    }

    @Override
    public HashMap<String, Object> softDeleteInvoice(Long id) {
        return null;
    }
}
