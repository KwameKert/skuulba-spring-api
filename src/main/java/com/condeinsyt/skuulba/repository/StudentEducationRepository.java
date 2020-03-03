package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentEducationRepository extends JpaRepository<StudentEducation, Long> {

    List<StudentEducation> findByStudentId(Long id);
}
