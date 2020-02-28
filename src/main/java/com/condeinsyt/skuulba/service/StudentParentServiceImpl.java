package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.model.StudentParent;
import com.condeinsyt.skuulba.repository.StudentParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.tree.ExpandVetoException;
import java.util.HashMap;

@Service
public class StudentParentServiceImpl implements StudentParentService {

    private StudentParentRepository studentParentRepository;


    @Autowired
    public StudentParentServiceImpl(StudentParentRepository studentParentRepository){
        this.studentParentRepository = studentParentRepository;
    }
    @Override
    public HashMap<String, Object> createStudentParent(StudentParent studentParent) {

        HashMap<String, Object> responseData = new HashMap<>();

        try{
            StudentParent newStudentParent = studentParentRepository.save(studentParent);
            responseData.put("data",newStudentParent);
            responseData.put("message","New User created");
            responseData.put("status", HttpStatus.OK.value());
        }catch (Exception e){

            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());

        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> updateStudentParent(StudentParent studentParent) {
        return null;
    }

    @Override
    public HashMap<String, Object> listStudentParent() {
        return null;
    }

    @Override
    public HashMap<String, Object> findStudentParent(Long id) {
        return null;
    }

    @Override
    public HashMap<String, Object> deleteStudentParent(Long id) {
        return null;
    }
}
