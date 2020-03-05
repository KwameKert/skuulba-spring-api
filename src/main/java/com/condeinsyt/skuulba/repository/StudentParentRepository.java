package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentParentRepository extends JpaRepository<StudentParent, Long> {

    List<StudentParent> findAllByStudentId(Long id);
}
