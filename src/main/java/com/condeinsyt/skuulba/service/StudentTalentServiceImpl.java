package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.StudentTalentsDTO;
import com.condeinsyt.skuulba.model.StudentTalent;
import com.condeinsyt.skuulba.repository.StudentTalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentTalentServiceImpl implements StudentTalentService {


    private StudentTalentRepository studentTalentRepository;

    @Autowired
    public StudentTalentServiceImpl(StudentTalentRepository studentTalentRepository) {
        this.studentTalentRepository = studentTalentRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }
    @Override
    public HashMap<String, Object> createTalent(StudentTalentsDTO studentTalentsDTO) {


        ArrayList<StudentTalent> content = studentTalentsDTO.getTalents();

        try{
            for(StudentTalent studentT : content){
                StudentTalent newStudentTalent = this.studentTalentRepository.save(studentT);
            }
            return responseAPI(null,"Talent was added to student  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
                return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> updateTalent(StudentTalent studentTalent) {

        Optional<StudentTalent> studentTalentFound = studentTalentRepository.findById(studentTalent.getId());
        try{
            if(!studentTalentFound.isPresent()){
                return responseAPI(null,"Student talent not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
            StudentTalent updatedTalent = studentTalentRepository.save(studentTalent);
            return responseAPI(updatedTalent, "Talent was updated on student  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> deleteTalent(Long id) {
        Optional<StudentTalent> studentTalentFound = studentTalentRepository.findById(id);
        Long studId = studentTalentFound.get().getStudentId();
        try{
            if(!studentTalentFound.isPresent()){
                return responseAPI(null,"Student talent not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
           studentTalentRepository.deleteById(id);
           return listStudentTalent(studId);

        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> listStudentTalent(Long id) {
        try{

            List<StudentTalent> studentTalents = studentTalentRepository.findByStudentId(id);
            if(!studentTalents.isEmpty()){
                return responseAPI(null,"Student talents not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }

            return responseAPI(studentTalents, "Talent was found  \uD83E\uDD7A",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> findStudentTalentById(Long id) {
        Optional<StudentTalent> studentTalentFound = studentTalentRepository.findById(id);
        try{
            if(!studentTalentFound.isPresent()){
                return responseAPI(null,"Student talent not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }
         return responseAPI(studentTalentFound,"Talent was found  \uD83E\uDD7A",HttpStatus.OK);

        }catch (Exception e){
            return responseAPI(null, e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
