package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentAwardDTO;
import com.condeinsyt.skuulba.model.StudentAward;
import com.condeinsyt.skuulba.repository.StudentAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAwardServiceImpl implements StudentAwardService {

    private StudentAwardRepository studentAwardRepository;


    @Autowired
    public StudentAwardServiceImpl(StudentAwardRepository studentAwardRepository) {
        this.studentAwardRepository = studentAwardRepository;
    }


    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> createAward(StudentAwardDTO studentAwardDTO) {


        ArrayList<StudentAward> content = studentAwardDTO.getAwards();

        try{
            for(StudentAward studentA : content){
                StudentAward newStudentAward= this.studentAwardRepository.save(studentA);
            }
            return responseAPI(null,"Award was added to student  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

        }
    }

    @Override
    public HashMap<String, Object> updateAward(StudentAward studentAward) {
        Optional<StudentAward> studentAwardFound = studentAwardRepository.findById(studentAward.getId());
        try{
            if(!studentAwardFound.isPresent()){
                return responseAPI(null,"Student award not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
            StudentAward updatedAward = studentAwardRepository.save(studentAward);
            return responseAPI(updatedAward, "Award was updated on student  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> deleteAward(Long id) {

        Optional<StudentAward> studentAwardFound = studentAwardRepository.findById(id);
        Long studId = studentAwardFound.get().getstudentId();
        try{
            if(!studentAwardFound.isPresent()){
                return responseAPI(null,"Student award not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
            studentAwardRepository.deleteById(id);
            return listStudentAward(studId);

        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> listStudentAward(Long id) {
        try{

            List<StudentAward> studentAwards = studentAwardRepository.findByStudentId(id);
            if(!studentAwards.isEmpty()){
                return responseAPI(null,"Student awards not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }

            return responseAPI(studentAwards, "Awards was found  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> findStudentAwardById(Long id) {
        Optional<StudentAward> studentAwardFound = studentAwardRepository.findById(id);
        try{
            if(!studentAwardFound.isPresent()){
                return responseAPI(null,"Student award not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
            return responseAPI(studentAwardFound,"Student award was found  \uD83E\uDD7A",HttpStatus.OK);

        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
