package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.GetStudentDetailsDTO;
import com.condeinsyt.skuulba.model.*;
import com.condeinsyt.skuulba.repository.*;
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
    private StudentParentRepository studentParentRepository;
    private StudentHealthRepository studentHealthRepository;
    private StudentEducationRepository studentEducationRepository;
    private StudentAwardRepository studentAwardRepository;
    private StudentHandicapRepository studentHandicapRepository;
    private StudentTalentRepository studentTalentRepository;
    private StudentPersonalityRepository studentPersonalityRepository;
    private StudentPhysicalRepository studentPhysicalRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentParentRepository studentParentRepository, StudentHealthRepository studentHealthRepository, StudentEducationRepository studentEducationRepository, StudentAwardRepository studentAwardRepository, StudentHandicapRepository studentHandicapRepository, StudentTalentRepository studentTalentRepository, StudentPersonalityRepository studentPersonalityRepository, StudentPhysicalRepository studentPhysicalRepository) {
        this.studentRepository = studentRepository;
        this.studentParentRepository = studentParentRepository;
        this.studentHealthRepository = studentHealthRepository;
        this.studentEducationRepository = studentEducationRepository;
        this.studentAwardRepository = studentAwardRepository;
        this.studentHandicapRepository = studentHandicapRepository;
        this.studentTalentRepository = studentTalentRepository;
        this.studentPersonalityRepository = studentPersonalityRepository;
        this.studentPhysicalRepository = studentPhysicalRepository;
    }




    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
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

            Student updatedStudent  = studentRepository.save(student);
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


    @Override
    public HashMap<String, Object> getStudentDetails(Long id){
        try{
            Optional<Student> student = studentRepository.findById(id);
            List<StudentAward> studentAward = studentAwardRepository.findAllByStudentId(id);
            Optional<StudentHealth> studentHealth  = studentHealthRepository.findByStudentId(id);
            List<StudentPersonality> studentPersonality = studentPersonalityRepository.findAllByStudentId(id);
            List<StudentTalent> studentTalent = studentTalentRepository.findAllByStudentId(id);
            List<StudentEducation> studentEducation = studentEducationRepository.findAllByStudentId(id);
            List<StudentPhysical> studentPhysical = studentPhysicalRepository.findAllByStudentId(id);
            List<StudentParent> studentParents = studentParentRepository.findAllByStudentId(id);
            List<StudentHandicap> studentHandicaps = studentHandicapRepository.findAllByStudentId(id);

            GetStudentDetailsDTO studentDetails = new GetStudentDetailsDTO();
            student.ifPresent(studentDetails::setStudent);

        studentHealth.ifPresent(studentDetails::setStudentHealth);

            if(!studentAward.isEmpty()){
                studentDetails.setStudentAward(studentAward);
            }

            if(!studentEducation.isEmpty()){
                studentDetails.setStudentEducation(studentEducation);
            }
            if(!studentPersonality.isEmpty()){
                studentDetails.setStudentPersonalities(studentPersonality);
            }

            if(!studentHandicaps.isEmpty()){
                studentDetails.setStudentHandicap(studentHandicaps);
            }

            if(!studentPhysical.isEmpty()){
                studentDetails.setStudentPhysical(studentPhysical);
            }

            if(!studentTalent.isEmpty()){
                studentDetails.setStudentTalent(studentTalent);
            }

            if(!studentParents.isEmpty()){
                studentDetails.setStudentParent(studentParents);
            }

            return responseAPI(studentDetails,"Student physique found \uD83D\uDE42",HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

        }
    }

    @Override
    public HashMap<String, Object> searchStudentDetails() {
        try{
            List<Student> allStudents = studentRepository.findAll();
            if(!allStudents.isEmpty()){
                return responseAPI(null,"Student not found \uD83E\uDD7A",HttpStatus.NO_CONTENT);
            }else{
                return responseAPI(allStudents,"Students found \uD83D\uDE42",HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }


}
