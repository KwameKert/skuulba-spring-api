package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
