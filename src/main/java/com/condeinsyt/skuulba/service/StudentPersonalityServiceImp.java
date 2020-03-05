package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentPersonalityDTO;
import com.condeinsyt.skuulba.model.StudentPersonality;
import com.condeinsyt.skuulba.repository.StudentPersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentPersonalityServiceImp implements StudentPersonalityService {

    private StudentPersonalityRepository studentPersonalityRepository;

    @Autowired
    public StudentPersonalityServiceImp(StudentPersonalityRepository studentPersonalityRepository){
        this.studentPersonalityRepository = studentPersonalityRepository;
    }


    @Override
    public HashMap<String, Object> createPersonality(StudentPersonalityDTO studentPersonalityDTO) {
        HashMap<String, Object> responseData = new HashMap<>();

        ArrayList<StudentPersonality> content = studentPersonalityDTO.getPersonalities();

        try{
            for(StudentPersonality studentP : content){
                StudentPersonality newStudentPersonality  = this.studentPersonalityRepository.save(studentP);
            }
            responseData.put("data",null);
            responseData.put("message","Personality Added to student");
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
    public HashMap<String, Object> updatePersonality(StudentPersonality studentPersonality) {
        HashMap<String, Object> responseData = new HashMap<>();

        try{
            Optional<StudentPersonality> studentPersonalityFound = studentPersonalityRepository.findById(studentPersonality.getId());

            if(!studentPersonalityFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student personality found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            StudentPersonality updatedStudent  = studentPersonalityRepository.save(studentPersonality);
            responseData.put("data",updatedStudent);
            responseData.put("message","Student Personality updated successfully");
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
    public HashMap<String, Object> deletePersonality(Long id) {
        HashMap<String, Object > responseData = new HashMap<>();

        try{

            Optional<StudentPersonality> studentPersonalityFound = studentPersonalityRepository.findById(id);
            Long pId = studentPersonalityFound.get().getId();

            if(!studentPersonalityFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Physical not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            studentPersonalityRepository.deleteById(id);
            return findStudentPersonalityById(pId);
        } catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> listStudentPersonality(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            List<StudentPersonality> studentPersonalityList = studentPersonalityRepository.findAllByStudentId(id);
            if (studentPersonalityList.isEmpty()) {
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message", "Student personality found \uD83E\uDD7A");
                responseData.put("status", HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data", studentPersonalityList);
            responseData.put("message", "Student personality found \uD83D\uDE42");
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
    public HashMap<String, Object> findStudentPersonalityById(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<StudentPersonality> foundStudentPersonality = studentPersonalityRepository.findById(id);
        try{
            if(!foundStudentPersonality.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Personality not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",foundStudentPersonality);
            responseData.put("message","Student Personality found \uD83D\uDE42");
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
