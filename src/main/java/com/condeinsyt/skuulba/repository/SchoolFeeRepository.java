package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.SchoolFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolFeeRepository extends JpaRepository<SchoolFee, Long> {

    List<SchoolFee> findAllByStudentClassLike(String studentClass);

    List<SchoolFee> findAllByFullNameLike(String name);
}
