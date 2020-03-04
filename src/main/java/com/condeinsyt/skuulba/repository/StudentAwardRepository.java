package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentAward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAwardRepository extends JpaRepository<StudentAward, Long> {

    List<StudentAward> findByStudentId(Long id);
}
