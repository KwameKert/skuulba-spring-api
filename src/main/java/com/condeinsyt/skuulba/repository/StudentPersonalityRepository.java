package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentPersonality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPersonalityRepository extends JpaRepository<StudentPersonality, Long> {

    List<StudentPersonality> findByStudentId(Long id);

}
