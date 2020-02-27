package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.User;

import java.util.HashMap;

public interface UserService {

     HashMap<String, Object> createUser(User user);

     HashMap<String, Object> listUsers();

    HashMap<String, Object> findUserById(Long userId);

    HashMap<String, Object> updateUser(User user);

     HashMap<String, Object> deleteUser(Long userId);
}
