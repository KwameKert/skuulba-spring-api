package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.model.StudentParent;
import com.condeinsyt.skuulba.repository.StudentParentRepository;
import com.condeinsyt.skuulba.service.interfaces.StudentParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentParentServiceImpl implements StudentParentService {

    private StudentParentRepository studentParentRepository;


    @Autowired
    public StudentParentServiceImpl(StudentParentRepository studentParentRepository){
        this.studentParentRepository = studentParentRepository;
    }



    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
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
        if ( studentParent.getId() == null){
            return this.createStudentParent(studentParent);
        }
        try{
            Optional<StudentParent> studentParentFound = this.studentParentRepository.findById(studentParent.getId());
            if(!studentParentFound.isPresent()){
                return responseAPI(null,"Student parent not found",HttpStatus.NO_CONTENT);
            }

            StudentParent updateParent = this.studentParentRepository.save(studentParent);
            return responseAPI(updateParent,"Student parent updated successfully",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listStudentParent(Long id) {
        try{
            List<StudentParent> listStudentParent = this.studentParentRepository.findAllByStudentId(id);

            if(listStudentParent.isEmpty()){
                return responseAPI(null,"No student parent found",HttpStatus.NO_CONTENT);
            }

            return responseAPI(listStudentParent,"Student parents found",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

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
