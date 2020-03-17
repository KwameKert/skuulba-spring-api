package com.condeinsyt.skuulba.service.interfaces;

import com.condeinsyt.skuulba.model.InvoiceItem;

import java.util.HashMap;

public interface InvoiceItemService {


    HashMap<String, Object> createItem(InvoiceItem invoiceItem);

    HashMap<String, Object> updateItem(InvoiceItem invoiceItem);

    HashMap<String, Object> softDeleteItem(Long id);

    HashMap<String, Object>  listItemsForInvoice(Long id);
}
