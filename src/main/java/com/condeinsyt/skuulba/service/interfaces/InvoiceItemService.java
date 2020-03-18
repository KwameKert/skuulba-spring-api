package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.model.Invoice;
import com.condeinsyt.skuulba.model.InvoiceItem;

import java.util.HashMap;
import java.util.List;

public interface InvoiceItemService {


    HashMap<String, Object> createItem(InvoiceItem invoiceItem);

    HashMap<String, Object> updateItem(InvoiceItem invoiceItem);

    HashMap<String, Object> softDeleteItem(Long id);

    List<InvoiceItem> listItemsForInvoice(Invoice invoice);
}
