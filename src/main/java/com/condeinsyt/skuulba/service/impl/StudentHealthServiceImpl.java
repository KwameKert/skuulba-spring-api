package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.model.StudentHealth;
import com.condeinsyt.skuulba.repository.StudentHealthRepository;
import com.condeinsyt.skuulba.service.interfaces.StudentHealthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@Service
public class StudentHealthServiceImpl implements StudentHealthService {

    private StudentHealthRepository studentHealthRepository;

    public StudentHealthServiceImpl(StudentHealthRepository studentHealthRepository){
        this.studentHealthRepository = studentHealthRepository;
    }

    @Override
    public HashMap<String, Object> createHealth(StudentHealth studentHealth) {
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            StudentHealth newStudentHealth = studentHealthRepository.save(studentHealth);
            responseData.put("data",newStudentHealth);
            responseData.put("message","Student Health added successfully");
            responseData.put("status", HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;
    }

    @Override
    public HashMap<String, Object> updateHealth(StudentHealth studentHealth) {
        HashMap<String, Object> responseData = new HashMap<>();

        try {
            Optional<StudentHealth> userFound = studentHealthRepository.findById(studentHealth.getId());


            if(!userFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student health found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            StudentHealth updatedStudentHealth  = studentHealthRepository.save(studentHealth);

            responseData.put("data",updatedStudentHealth);
            responseData.put("message","Student Health updated successfully");
            responseData.put("status",HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;
    }

    @Override
    public HashMap<String, Object> findHealthByStudentId(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        try {
            Optional<StudentHealth> studentHealthFound = studentHealthRepository.findByStudentId(id);

            if (!studentHealthFound.isPresent()) {
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message", "No student health found");
                responseData.put("status", HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data", studentHealthFound);
            responseData.put("message", "Student health found");
            responseData.put("status", HttpStatus.OK.value());
            return responseData;
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;

    }

    @Override
    public HashMap<String, Object> findStudentHealth(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<StudentHealth> foundStudentHealth = studentHealthRepository.findById(id);
        try{
            if(!foundStudentHealth.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Physical not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",foundStudentHealth);
            responseData.put("message","Student Health found \uD83D\uDE42");
            responseData.put("status",HttpStatus.OK.value());
        }catch (Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> deleteStudentHealth(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<StudentHealth> foundStudentHealth = studentHealthRepository.findById(id);
        Long studId = foundStudentHealth.get().getStudentId();
        try{
            if(!foundStudentHealth.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Physical not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            studentHealthRepository.deleteById(id);
            findHealthByStudentId(studId);
        }catch (Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }
}
