package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.dto.InvoiceDTO;
import com.condeinsyt.skuulba.model.Invoice;
import com.condeinsyt.skuulba.model.InvoiceItem;
import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.repository.InvoiceFeeRepository;
import com.condeinsyt.skuulba.repository.InvoiceItemRepository;
import com.condeinsyt.skuulba.repository.StudentRepository;
import com.condeinsyt.skuulba.service.interfaces.InvoiceFeeService;
import com.condeinsyt.skuulba.service.interfaces.InvoiceItemService;
import com.condeinsyt.skuulba.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceFeeServiceImpl implements InvoiceFeeService {

    private InvoiceFeeRepository invoiceFeeRepository;
    private InvoiceItemService invoiceItemService;
    private StudentRepository studentRepository;

    @Autowired
    public InvoiceFeeServiceImpl(InvoiceFeeRepository invoiceFeeRepository, InvoiceItemService invoiceItemService, StudentRepository studentRepository) {
        this.invoiceFeeRepository = invoiceFeeRepository;
        this.invoiceItemService = invoiceItemService;
        this.studentRepository = studentRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }
    @Override
    public HashMap<String, Object> createInvoice(InvoiceDTO invoiceDTO) {

        try{
            for (Long  studId: invoiceDTO.getStudents()){
                Optional<Student> student = this.studentRepository.findById(studId);
                Invoice invoice = new Invoice();
                invoice.setType(invoiceDTO.getType());
                invoice.setAmount(invoiceDTO.getAmount());
                invoice.setBillDate(invoiceDTO.getBillDate());
                invoice.setBillDueDate(invoiceDTO.getBillDueDate());
                invoice.setNotes(invoiceDTO.getNotes());
                invoice.setCode(invoiceDTO.getCode());
                invoice.setTerms(invoiceDTO.getTerms());
                invoice.setStudent(student.get());
                invoice.setValue(invoiceDTO.getValue());
                invoice.setStatus("active");
                Invoice savedInvoice = this.invoiceFeeRepository.save(invoice);

                for(InvoiceItem invoiceItem: invoiceDTO.getInvoiceItems()){
                    InvoiceItem newItem = new InvoiceItem();
                    newItem.setInvoice(savedInvoice);
                    newItem.setAmount(invoiceItem.getAmount());
                    newItem.setName(invoiceItem.getName());
                    newItem.setStatus("active");
                    newItem.setRate(invoiceItem.getRate());
                    newItem.setQuantity(invoiceItem.getQuantity());
                    System.out.println(newItem);

                    this.invoiceItemService.createItem(newItem);
                }
            }

            return responseAPI(null,"Invoice saved successfully",HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> updateInvoice(Invoice invoiceFee) {
        try{

            Optional<Invoice> invoice = this.invoiceFeeRepository.findById(invoiceFee.getId());
            if(!invoice.isPresent()){
                return responseAPI(null,"No invoice found",HttpStatus.NO_CONTENT);
            }
            Invoice savedInvoice = this.invoiceFeeRepository.save(invoiceFee);
            return responseAPI(savedInvoice, "Invoice updated successfully",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listInvoice() {
        try{
            List<Invoice> invoices = this.invoiceFeeRepository.findAllByStatusOrderByIdDesc("active");

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
        try{
            Optional<Invoice> invoiceFound = this.invoiceFeeRepository.findById(id);

            if(!invoiceFound.isPresent()) {
                return responseAPI(null, "No invoice found", HttpStatus.NO_CONTENT);
            }

            return responseAPI(invoiceFound,"Invoice found ",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> softDeleteInvoice(Long id) {
        try{
            Optional<Invoice> invoiceFound = this.invoiceFeeRepository.findById(id);
            if(!invoiceFound.isPresent()) {
                return responseAPI(null, "No invoice found", HttpStatus.NO_CONTENT);
            }
            this.invoiceFeeRepository.UpdateInvoiceStatus(id,"inactive");
           return this.listInvoice();
        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

//    @Override
//    public HashMap<String, Object> listStudentDailyFee(Long id) {
//        try{
//            Optional<Student> student = this.studentRepository.findById(id);
//
//            if(student.isPresent()){
//
//                List<Invoice> invoices = this.invoiceFeeRepository.findAllByStudent(student.get());
//                return responseAPI(invoices, "Invoices found", HttpStatus.OK);
//            }
//
//            return responseAPI(null, "No invoice found", HttpStatus.NO_CONTENT);
//
//
//        }catch(Exception e){
//            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
//        }
  //  }
}
