package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentHandicap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentHandicapRepository extends JpaRepository<StudentHandicap, Long> {

    List<StudentHandicap> findByStudentId(Long id);
}
