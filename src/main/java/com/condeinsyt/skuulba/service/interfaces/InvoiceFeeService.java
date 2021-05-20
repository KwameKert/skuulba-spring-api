package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.dto.InvoiceDTO;
import com.condeinsyt.skuulba.model.Invoice;

import java.util.HashMap;

public interface InvoiceFeeService {

    HashMap<String, Object> createInvoice(InvoiceDTO invoiceDTO);

    HashMap<String, Object> updateInvoice(Invoice invoice);
    HashMap<String, Object> listInvoice();
    HashMap<String, Object> getInvoice(Long id);
    HashMap<String, Object> softDeleteInvoice(Long id);
   // HashMap<String, Object> listStudentDailyFee(Long id);

}
