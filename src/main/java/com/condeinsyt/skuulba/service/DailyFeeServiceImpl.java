package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.DailyFees;
import com.condeinsyt.skuulba.repository.DailyFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DailyFeeServiceImpl implements DailyFeeService {

    private DailyFeeRepository dailyFeeRepository;

    @Autowired
    public DailyFeeServiceImpl(DailyFeeRepository dailyFeeRepository) {
        this.dailyFeeRepository = dailyFeeRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> addFee(DailyFees dailyFees) {
        try {
            DailyFees dailyFeeSaved = dailyFeeRepository.save(dailyFees);
            return responseAPI(dailyFees,"DailyFee collected",HttpStatus.OK);
        }catch (Exception e){
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);

        }
    }
}
