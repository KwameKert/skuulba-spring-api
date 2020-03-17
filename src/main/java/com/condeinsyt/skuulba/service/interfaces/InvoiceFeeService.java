package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.dto.InvoiceDTO;
import com.condeinsyt.skuulba.model.InvoiceFee;

import java.util.HashMap;

public interface InvoiceFeeService {

    HashMap<String, Object> createInvoice(InvoiceDTO invoiceDTO);

    HashMap<String, Object> updateInvoice(InvoiceFee invoiceFee);
    HashMap<String, Object> listInvoice();
    HashMap<String, Object> getInvoice(Long id);
    HashMap<String, Object> softDeleteInvoice(Long id);


}
