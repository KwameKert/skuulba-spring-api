package com.condeinsyt.skuulba.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUser(){
        user = new User();
        user.setId(1L);
        user.setStatus(1);
        user.setUserName("kwameKert");
        user.setPassword("password");
        user.setRole("super_admin");

    }
    @Test
    void getId() {
        assertEquals(1L,user.getId());
    }

    @Test
    void getStatus() {
        assertEquals(1,user.getStatus());
    }


    @Test
    void getUserName() {
        assertEquals("kwameKert", user.getUserName());
    }



    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }





}