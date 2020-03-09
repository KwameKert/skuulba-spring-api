package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.dto.DailyFeeDTO;
import com.condeinsyt.skuulba.model.DailyFees;
import com.condeinsyt.skuulba.model.Student;
import com.condeinsyt.skuulba.repository.DailyFeeRepository;
import com.condeinsyt.skuulba.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DailyFeeServiceImpl implements DailyFeeService {

    private DailyFeeRepository dailyFeeRepository;
    private StudentRepository studentRepository;

    @Autowired
    public DailyFeeServiceImpl(DailyFeeRepository dailyFeeRepository,StudentRepository studentRepository) {
        this.dailyFeeRepository = dailyFeeRepository;
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
    public HashMap<String, Object> addFee(DailyFeeDTO dailyFeeDTO ) {
        try {

            Optional<Student> foundStudent = this.studentRepository.findById(dailyFeeDTO.getStudentId());

            if(!foundStudent.isPresent()){
                return this.responseAPI(null, "No student found ", HttpStatus.NO_CONTENT);
            }

            DailyFees dailyFees = new DailyFees();
            dailyFees.setAmount(dailyFeeDTO.getAmount());
            dailyFees.setStudent(foundStudent.get());
            dailyFees.setStudentClass(foundStudent.get().getStudentClass());
            dailyFees.setGender(foundStudent.get().getGender());
            dailyFees.setType(dailyFeeDTO.getType());
            dailyFees.setFullName(foundStudent.get().getLastName()+ " "+foundStudent.get().getOtherNames());


            DailyFees dailyFeeSaved = dailyFeeRepository.save(dailyFees);
            return responseAPI(dailyFeeSaved,"DailyFee collected",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

        }
    }

    @Override
    public HashMap<String, Object> listFees() {
        try{
            List<DailyFees> allFees = this.dailyFeeRepository.findAll();

            if(!allFees.isEmpty()){
                return responseAPI(allFees, "Student Daily Fee found",HttpStatus.OK);
            }

            return responseAPI(null, "Student daily fee empty",HttpStatus.NO_CONTENT);


        }catch (Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

        }
    }
}
