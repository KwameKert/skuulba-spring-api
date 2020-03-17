package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.dto.SchoolFeeDTO;
import com.condeinsyt.skuulba.dto.SearchDTO;
import com.condeinsyt.skuulba.model.SchoolFee;
import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.repository.SchoolFeeRepository;
import com.condeinsyt.skuulba.repository.StudentRepository;
import com.condeinsyt.skuulba.service.interfaces.SchoolFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolFeeServiceImpl implements SchoolFeeService {

    private SchoolFeeRepository schoolFeeRepository;
    private StudentRepository studentRepository;

    @Autowired
    public SchoolFeeServiceImpl(SchoolFeeRepository schoolFeeRepository, StudentRepository studentRepository) {
        this.schoolFeeRepository = schoolFeeRepository;
        this.studentRepository = studentRepository;
    }


    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }
    @Override
    public HashMap<String, Object> paySchoolFee(SchoolFeeDTO schoolFeeDTO) {
        try{

            Optional<Student> foundStudent = studentRepository.findById(schoolFeeDTO.getStudentId());

            if(!foundStudent.isPresent()){
                return responseAPI(null,"No student here",HttpStatus.NO_CONTENT);
            }

            SchoolFee schoolFee = new SchoolFee();
            schoolFee.setStudent(foundStudent.get());
            schoolFee.setAmount(schoolFeeDTO.getAmount());


            SchoolFee paidFee = this.schoolFeeRepository.save(schoolFee);
            return responseAPI(paidFee, "Student school fee paid",HttpStatus.OK);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listSchoolFee() {
        try {

            List<SchoolFee> student_schoolFees = this.schoolFeeRepository.findAllByOrderByIdAsc();
           // System.out.println(student_schoolFees.getStudent());

            if(!student_schoolFees.isEmpty()){
                return responseAPI(student_schoolFees,"Student Fees found",HttpStatus.OK);
            }
            return responseAPI(null,"Student Fees not found",HttpStatus.NO_CONTENT);

        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> listSchoolFeeByStudentClass(SearchDTO searchDTO) {
        try{
            int param = searchDTO.getParam();

            if(param == 1){
                System.out.println(searchDTO);
                System.out.println(searchDTO.getValue());
                System.out.println(searchDTO.getParam());
                List<SchoolFee> schoolFees = this.schoolFeeRepository.findAllByStudentClassLike(searchDTO.getValue());
                if(!schoolFees.isEmpty()){
                    return responseAPI(schoolFees,"Students found",HttpStatus.OK);
                }
                return this.responseAPI(null,"Students  not Found",HttpStatus.NO_CONTENT);
            }else{
                List<SchoolFee> schoolFees = this.schoolFeeRepository.findAllByFullNameLike(searchDTO.getValue());
                if(!schoolFees.isEmpty()){
                    return responseAPI(schoolFees,"Students found",HttpStatus.OK);
                }
                return this.responseAPI(null,"Students  not Found",HttpStatus.NO_CONTENT);
            }



        }catch(Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listSchoolFeeByFullName(String name) {
        return null;
    }


}
