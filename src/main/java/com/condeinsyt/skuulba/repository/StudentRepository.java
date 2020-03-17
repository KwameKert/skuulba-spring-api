package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

   @Modifying(clearAutomatically = true)
    @Query("UPDATE Student s SET s.status = ?2 WHERE s.id = ?1")
   @Transactional
    int UpdateStudentStatus(Long studentId, String status);

    List<Student> findAllByStatusOrderByIdAsc(String status);
    List<Student> findAllByOrderByIdAsc();
    List<Student>  findAllByLastNameLike(String value);

    List<Student> findAllByOtherNamesLike(String value);
    List<Student> findAllByStudentClassLike(String studentClass);
}
