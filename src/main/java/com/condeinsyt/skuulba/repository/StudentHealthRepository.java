package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentHealth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentHealthRepository  extends JpaRepository<StudentHealth, Long> {

    Optional<StudentHealth> findByStudentId(Long id);
   // StudentHealth findByStudentId(Long id);
}
