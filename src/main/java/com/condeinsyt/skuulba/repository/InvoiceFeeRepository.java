package com.condeinsyt.skuulba.repository;


import com.condeinsyt.skuulba.model.InvoiceFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface InvoiceFeeRepository extends JpaRepository<InvoiceFee, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE InvoiceFee f SET f.status = ?2 WHERE f.id = ?1")
    @Transactional
    int UpdateInvoiceStatus(Long invoiceId, String status);

    List<InvoiceFee> findAllByStatusOrderByIdDesc(String status);
}
