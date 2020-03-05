package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentEducationDTO;
import com.condeinsyt.skuulba.model.StudentEducation;
import com.condeinsyt.skuulba.repository.StudentEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentEducationServiceImpl implements StudentEducationService {

    private StudentEducationRepository studentEducationRepository;


    @Autowired
    public StudentEducationServiceImpl(StudentEducationRepository studentEducationRepository){
        this.studentEducationRepository = studentEducationRepository;
    }


    @Override
    public HashMap<String, Object> createEducation(StudentEducationDTO studentEducationDTO) {
        HashMap<String, Object> responseData = new HashMap<>();

        ArrayList<StudentEducation> content = studentEducationDTO.getEducations();

        try{
            for(StudentEducation studentE : content){
                StudentEducation newStudentEducation  = this.studentEducationRepository.save(studentE);
            }
            responseData.put("data",null);
            responseData.put("message","Education Added to student");
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
    public HashMap<String, Object> updateEducation(StudentEducation studentEducation) {
        HashMap<String, Object> responseData = new HashMap<>();

        try{
            Optional<StudentEducation> studentEducationFound = studentEducationRepository.findById(studentEducation.getId());

            if(!studentEducationFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student education found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            StudentEducation updatedEducation  = studentEducationRepository.save(studentEducation);
            responseData.put("data",updatedEducation);
            responseData.put("message","Student Education updated successfully");
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
    public HashMap<String, Object> deleteEducation(Long id) {
        HashMap<String, Object > responseData = new HashMap<>();

        try{

            Optional<StudentEducation> studentEducationFound = studentEducationRepository.findById(id);
            Long studId = studentEducationFound.get().getStudentId();


//            if(!studentEducationFound.isPresent()){
//                responseData.put("data", Collections.EMPTY_LIST);
//                responseData.put("message","Student Education not found \uD83E\uDD7A");
//                responseData.put("status",HttpStatus.NO_CONTENT.value());
//                return responseData;
//            }
            studentEducationRepository.deleteById(id);
            return findStudentEducationById(studId);
        } catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> listStudentEducation(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            List<StudentEducation> studentEducationList = studentEducationRepository.findByStudentId(id);
            if (studentEducationList.isEmpty()) {
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message", "Student education not found \uD83E\uDD7A");
                responseData.put("status", HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data", studentEducationList);
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
    public HashMap<String, Object> findStudentEducationById(Long id) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<StudentEducation> foundStudentEducation = studentEducationRepository.findById(id);
        try{
            if(!foundStudentEducation.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Education not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",foundStudentEducation);
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
