package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.User;
import com.condeinsyt.skuulba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public HashMap<String, Object> createUser(User user){

        HashMap<String, Object> responseData = new HashMap<>();
        try {
            User newUser = userRepository.save(user);
            responseData.put("data",newUser);
            responseData.put("message","User added successfully");
            responseData.put("status",HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;
    }


    public HashMap<String, Object> listUsers(){
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            List<User> allUsers = userRepository.findAll();
            if(allUsers.isEmpty()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No users found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data",allUsers);
            responseData.put("message","User added successfully");
            responseData.put("status",HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;
    }

    public HashMap<String, Object> findUserById(long userId){
        HashMap<String, Object> responseData = new HashMap<>();
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (!optionalUser.isPresent()) {
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No users found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            responseData.put("data", optionalUser);
            responseData.put("message", "User found");
            responseData.put("status", HttpStatus.OK.value());
        }catch(Exception e){
                e.printStackTrace();
                responseData.put("data",null);
                responseData.put("message",e.getMessage());
                responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
            }

        return responseData;

    }


    //updating user
    public HashMap<String, Object> updateUser(User user){

        HashMap<String, Object> responseData = new HashMap<>();

        try {
            Optional<User> userFound = userRepository.findById(user.getId());
            if(!userFound.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No users found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }
            User oldUser = userFound.get();
            oldUser.setRole(user.getRole());
            oldUser.setStatus(user.getStatus());
            User updatedUser  = userRepository.save(oldUser);
            responseData.put("data",updatedUser);
            responseData.put("message","User updated successfully");
            responseData.put("status",HttpStatus.OK.value());
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseData;
    }


    //deleting  user
    public HashMap<String, Object> deleteUser(long userId){
        HashMap<String, Object> responseData = new HashMap<>();
        try{
            Optional<User> theUser = userRepository.findById(userId);

            if(!theUser.isPresent()){
                responseData.put("data", Collections.EMPTY_LIST);
                responseData.put("message","No user found");
                responseData.put("status",HttpStatus.NO_CONTENT.value());
                return responseData;
            }

            userRepository.deleteById(userId);
            return listUsers();
        }catch(Exception e){
            e.printStackTrace();
            responseData.put("data",null);
            responseData.put("message",e.getMessage());
            responseData.put("status", HttpStatus.EXPECTATION_FAILED.value());
            return responseData;
        }


    }






}
