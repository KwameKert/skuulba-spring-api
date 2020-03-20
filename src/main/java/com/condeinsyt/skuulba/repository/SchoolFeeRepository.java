package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.SchoolFee;
import com.condeinsyt.skuulba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolFeeRepository extends JpaRepository<SchoolFee, Long> {

    List<SchoolFee> findAllByOrderByIdAsc();
    List<SchoolFee> findAllByStudentClassLike(String studentClass);

    List<SchoolFee> findAllByFullNameLike(String name);

    List<SchoolFee> findAllByStudent(Student student);
}
