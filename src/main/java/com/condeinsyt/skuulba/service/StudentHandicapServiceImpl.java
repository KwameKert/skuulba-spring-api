package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentHandicapDTO;
import com.condeinsyt.skuulba.model.StudentHandicap;
import com.condeinsyt.skuulba.repository.StudentHandicapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentHandicapServiceImpl implements StudentHandicapService {

    private StudentHandicapRepository studentHandicapRepository;



    @Autowired
    public StudentHandicapServiceImpl(StudentHandicapRepository studentHandicapRepository) {
        this.studentHandicapRepository = studentHandicapRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }
    @Override
    public HashMap<String, Object> createHandicap(StudentHandicapDTO studentHandicapDTO) {
        HashMap<String, Object> responseData = new HashMap<>();

        ArrayList<StudentHandicap> content = studentHandicapDTO.getHandicaps();

        try{
            for(StudentHandicap studentH : content){
                StudentHandicap newStudentHandicap = this.studentHandicapRepository.save(studentH);
            }
            responseData.put("data",null);
            responseData.put("message","Handicap Added to student");
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
    public HashMap<String, Object> updateHandicap(StudentHandicap studentHandicap) {
        HashMap<String, Object> responseData = new HashMap<>();

        try{
            Optional<StudentHandicap> studentHandicapFound = studentHandicapRepository.findById(studentHandicap.getId());

            if(!studentHandicapFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student handicap found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            StudentHandicap updatedStudentHandicap  = studentHandicapRepository.save(studentHandicap);
            responseData.put("data",updatedStudentHandicap);
            responseData.put("message","Student Handicap updated successfully");
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
    public HashMap<String, Object> deleteHandicap(Long id) {
        HashMap<String, Object > responseData = new HashMap<>();

        try{

            Optional<StudentHandicap> studentHandicapFound = studentHandicapRepository.findById(id);
            Long studId = studentHandicapFound.get().getStudentId();

            if(!studentHandicapFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student Handicap not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            studentHandicapRepository.deleteById(id);
            listStudentHandicap(studId);
        } catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }

    @Override
    public HashMap<String, Object> listStudentHandicap(Long id) {
        try {
            List<StudentHandicap> studentHandicapList = studentHandicapRepository.findByStudentId(id);
            if (studentHandicapList.isEmpty()) {
                return responseAPI(Collections.EMPTY_LIST,"Student Handicap not found \uD83E\uDD7A", HttpStatus.NO_CONTENT);
            }
            return responseAPI(studentHandicapList,"Student handicap found \uD83E\uDD7A",HttpStatus.OK);
        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> findStudentHandicapById(Long id) {

        try {
            Optional<StudentHandicap> studentHandicap  = studentHandicapRepository.findById(id);

            if(studentHandicap.isPresent()){
                return responseAPI(Collections.EMPTY_LIST,"Student Handicap not found \uD83E\uDD7A", HttpStatus.NO_CONTENT);
            }

            return responseAPI(studentHandicap,"Student handicap found \uD83E\uDD7A",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
