package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.DailyFees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DailyFeeRepository extends JpaRepository<DailyFees,Long> {

    @Query(value = "SELECT\n" +
            "app_student_daily_fees.id,\n" +
            "app_student_daily_fees.amount,\n" +
            "app_student_daily_fees.created_at,\n" +
            "app_student_daily_fees.student_id,\n" +
            "app_student_daily_fees.type,\n" +
            "app_student_daily_fees.updated_at,\n" +
            "app_student_daily_fees.full_name,\n" +
            "app_student_daily_fees.student_class,\n" +
            "app_student_daily_fees.gender,\n" +
            "app_student.`status`\n" +
            "FROM\n" +
            "app_student\n" +
            "INNER JOIN app_student_daily_fees ON app_student_daily_fees.student_id = app_student.id WHERE app_student.status='active'", nativeQuery = true)
    List<DailyFees> findActiveDailyPayments();
    List<DailyFees> findAllByOrderByIdDesc();
}
