package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.dto.StudentPhysicalDTO;
import com.condeinsyt.skuulba.service.interfaces.StudentPhysicalService;
import com.condeinsyt.skuulba.model.StudentPhysical;
import com.condeinsyt.skuulba.repository.StudentPhysicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentPhysicalServiceImpl implements StudentPhysicalService {

    private StudentPhysicalRepository studentPhysicalRepository;

    @Autowired
    public StudentPhysicalServiceImpl(StudentPhysicalRepository studentPhysicalRepository){
        this.studentPhysicalRepository = studentPhysicalRepository;
    }

    @Override
    public HashMap<String, Object> createPhysical(StudentPhysicalDTO studentPhysical) {
        HashMap<String, Object> responseData = new HashMap<>();

        ArrayList<StudentPhysical> content = studentPhysical.getPhysicals();

        try{
            for(StudentPhysical studentP : content){
                StudentPhysical newStudentPhysical  = this.studentPhysicalRepository.save(studentP);
            }
            responseData.put("data",null);
            responseData.put("message","Physical Added to student");
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
    public HashMap<String, Object> updatePhysical(StudentPhysical studentPhysical) {
        HashMap<String, Object> responseData = new HashMap<>();

        try{
            Optional<StudentPhysical> studentPhysicalFound = studentPhysicalRepository.findById(studentPhysical.getId());

            if(!studentPhysicalFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student physique found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            StudentPhysical updatedStudent  = studentPhysicalRepository.save(studentPhysical);
            responseData.put("data",updatedStudent);
            responseData.put("message","Student updated successfully");
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
    public HashMap<String, Object> deletePhysical(Long id) {
        HashMap<String, Object > responseData = new HashMap<>();

        try{

            Optional<StudentPhysical> studentPhysicalFound = studentPhysicalRepository.findById(id);
            Long studId = studentPhysicalFound.get().getStudentId();

            if(!studentPhysicalFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Physical not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            studentPhysicalRepository.deleteById(id);
           return listStudentPhysical(studId);
        } catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> listStudentPhysical(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            List<StudentPhysical> studentPhysicalList = studentPhysicalRepository.findAllByStudentId(id);
            if (studentPhysicalList.isEmpty()) {
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message", "Student physique not found \uD83E\uDD7A");
                responseData.put("status", HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data", studentPhysicalList);
            responseData.put("message", "Student physique found \uD83D\uDE42");
            responseData.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            e.printStackTrace();
            responseData.put("data", null);
            responseData.put("message", e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> findStudentPhysicalById(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<StudentPhysical> foundStudentPhysical = studentPhysicalRepository.findById(id);
        try{
            if(!foundStudentPhysical.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Physical not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",foundStudentPhysical);
            responseData.put("message","Student Physical found \uD83D\uDE42");
            responseData.put("status",HttpStatus.OK.value());
        }catch (Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }
}
