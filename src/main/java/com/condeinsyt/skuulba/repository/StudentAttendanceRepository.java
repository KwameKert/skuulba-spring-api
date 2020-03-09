package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {

    //List<Student> findAllByS
}
