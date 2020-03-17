package com.condeinsyt.skuulba.controller;

import com.condeinsyt.skuulba.model.User;
import com.condeinsyt.skuulba.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }



}
