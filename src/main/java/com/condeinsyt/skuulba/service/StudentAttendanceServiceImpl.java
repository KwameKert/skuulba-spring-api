package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentAttendanceDTO;
import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.model.StudentAttendance;
import com.condeinsyt.skuulba.repository.StudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private StudentAttendanceRepository studentAttendanceRepository;

    @Autowired
    public StudentAttendanceServiceImpl(StudentAttendanceRepository studentAttendanceRepository) {
        this.studentAttendanceRepository = studentAttendanceRepository;
    }



    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> takeAttendance(StudentAttendanceDTO studentAttendanceDTO) {

            try{
                ArrayList<Student> content = studentAttendanceDTO.getStudents();

                for(Student student: content){
                    StudentAttendance studentAttendance = new StudentAttendance();
                    studentAttendance.setStudentId(student.getId());
                   StudentAttendance saveStudent =  this.studentAttendanceRepository.save(studentAttendance);
                }

                return responseAPI(null,"Students Attendance saved",HttpStatus.OK);


            }catch (Exception e){
                return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

            }
    }

    @Override
    public HashMap<String, Object> getClassAttendance(String studentClass) {
        return null;
    }
}
