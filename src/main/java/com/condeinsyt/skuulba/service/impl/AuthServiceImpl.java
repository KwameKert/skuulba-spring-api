package com.condeinsyt.skuulba.service.impl;

import com.condeinsyt.skuulba.model.User;
import com.condeinsyt.skuulba.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImpl {

    private AuthRepository authRepository;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository){
        this.authRepository = authRepository;
    }


    //Validating User
    public HashMap<String,Object> isUser(User user){
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            Optional<User> theUser = authRepository.findFirstByUserNameAndPassword(user.getUserName(),user.getPassword());

            if(!theUser.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","Invalid Credentials");
                responseData.put("status", HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",theUser);
            responseData.put("message","User is authenticated");
            responseData.put("status", HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
            return responseData;
        }

        return responseData;
    }

}
