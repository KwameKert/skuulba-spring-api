package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentTalent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentTalentRepository extends JpaRepository<StudentTalent, Long> {

    List<StudentTalent> findAllByStudentId(Long id);


}
