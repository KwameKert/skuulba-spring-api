package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByOrderByIdAsc();
    List<Student>  findAllByLastNameLike(String value);

    List<Student> findAllByOtherNamesLike(String value);
    List<Student> findAllByStudentClassLike(String studentClass);
}
