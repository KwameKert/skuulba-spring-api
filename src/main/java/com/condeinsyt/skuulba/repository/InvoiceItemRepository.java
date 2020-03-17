package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
}
