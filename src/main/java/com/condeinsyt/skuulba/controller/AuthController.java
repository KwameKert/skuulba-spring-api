package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.model.User;
import com.condeinsyt.skuulba.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping("/api/v1/auth/")
public class AuthController {

    private AuthServiceImpl authService;

    @Autowired
    public AuthController(AuthServiceImpl authService){
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> isValid(@Valid @RequestBody User user){
        return new ResponseEntity<>(authService.isUser(user), HttpStatus.OK);
    }

}
