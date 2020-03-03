package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.StudentPhysical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPhysicalRepository extends JpaRepository<StudentPhysical,Long> {

    List<StudentPhysical> findByStudentId(Long id);

}
