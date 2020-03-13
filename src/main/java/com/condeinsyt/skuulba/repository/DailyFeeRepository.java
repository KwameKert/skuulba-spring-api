package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.DailyFees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyFeeRepository extends JpaRepository<DailyFees,Long> {

    List<DailyFees> findAllByOrderByIdDesc();
}
