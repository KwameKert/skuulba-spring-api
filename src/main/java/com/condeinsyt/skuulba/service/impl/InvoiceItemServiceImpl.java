package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.model.Invoice;
import com.condeinsyt.skuulba.model.InvoiceItem;
import com.condeinsyt.skuulba.repository.InvoiceItemRepository;
import com.condeinsyt.skuulba.service.interfaces.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private InvoiceItemRepository invoiceItemRepository;

    @Autowired
    public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> createItem(InvoiceItem invoiceItem) {
        try{
            InvoiceItem savedItem = this.invoiceItemRepository.save(invoiceItem);
            return this.responseAPI(savedItem,"Item saved",HttpStatus.OK);

        }catch (Exception e){
            return this.responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> updateItem(InvoiceItem invoiceItem) {
        try{
            Optional<InvoiceItem> foundItem =  this.invoiceItemRepository.findById(invoiceItem.getId());
            if(!foundItem.isPresent()){
                return responseAPI(null,"No Item found",HttpStatus.NO_CONTENT);
            }

            this.invoiceItemRepository.save(foundItem.get());
            return responseAPI(foundItem,"Item updated successfully",HttpStatus.OK);

        }catch (Exception e){
            return this.responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> softDeleteItem(Long id) {
        try{
            Optional<InvoiceItem> foundItem =  this.invoiceItemRepository.findById(id);
            if(!foundItem.isPresent()){
                return responseAPI(null,"No Item found",HttpStatus.NO_CONTENT);
            }

            this.invoiceItemRepository.UpdateInvoiceStatus(id,"inactive");
            return this.responseAPI(null,"Item deleted successfully",HttpStatus.OK);

        }catch (Exception e){
            return this.responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public List<InvoiceItem> listItemsForInvoice(Invoice invoice) {
        try{

            List<InvoiceItem> foundList = this.invoiceItemRepository.findAllByInvoice(invoice);
            if(foundList.isEmpty()){
                return null;
            }
            return foundList;
        }catch(Exception e){
            throw e;
        }
    }


}
