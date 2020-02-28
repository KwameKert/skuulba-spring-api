package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public HashMap<String, Object> createStudent(Student student) {
        HashMap<String, Object> responseObj = new HashMap<>();

        try {
            Student newStudent = studentRepository.save(student);
            responseObj.put("data",newStudent);
            responseObj.put("message","New User created");
            responseObj.put("status", HttpStatus.OK.value());
        }catch( Exception e){
            e.printStackTrace();
            responseObj.put("data",null);
            responseObj.put("message",e.getMessage());
            responseObj.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

            return responseObj;
    }

    @Override
    public HashMap<String, Object> updateStudent(Student student) {
        HashMap<String, Object> responseData = new HashMap<>();

        try{
            Optional<Student> studentFound = studentRepository.findById(student.getId());

            if(!studentFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No student found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            Student oldStudent = studentFound.get();
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setOtherNames(student.getOtherNames());
            oldStudent.setMotherTongue(student.getMotherTongue());
            oldStudent.setHomeTown(student.getHomeTown());
            oldStudent.setDob(student.getDob());
            oldStudent.setLivingWith(student.getLivingWith());

            Student updatedStudent  = studentRepository.save(oldStudent);
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
    public HashMap<String, Object> listStudents() {
        HashMap<String, Object> responseData = new HashMap<>();
        try{
            List<Student> studentList = studentRepository.findAll();
            if(studentList.isEmpty()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Students not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",studentList);
            responseData.put("message","Students found \uD83D\uDE42");
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
    public HashMap<String, Object> findStudentById(Long studId) {
        HashMap<String, Object> responseData = new HashMap<>();

        Optional<Student> foundStudent = studentRepository.findById(studId);
        try{
            if(!foundStudent.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            responseData.put("data",foundStudent);
            responseData.put("message","Student found \uD83D\uDE42");
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
    public HashMap<String, Object> deleteStudent(Long studId) {
        HashMap<String, Object > responseData = new HashMap<>();

        try{

            Optional<Student> studentFound = studentRepository.findById(studId);

            if(!studentFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Student not found \uD83E\uDD7A");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            studentRepository.deleteById(studId);
            return listStudents();
        } catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }

        return responseData;
    }
}
