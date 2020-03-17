package com.condeinsyt.skuulba.service;

import com.condeinsyt.skuulba.model.User;
import com.condeinsyt.skuulba.repository.UserRepository;
import com.condeinsyt.skuulba.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest  {

    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void createUser() {
        User user = new User();
        user.setUserName("KwameKert");
        user.setPassword("password");
        user.setId(23L);
        user.setRole("admin");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        HashMap<String, Object> savedUser = userService.createUser(user);

        User extractedUser = (User) savedUser.get("data");
        assertEquals("KwaeKert", extractedUser.getUserName());
    }


    @Test
    void listUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Kwame","password","dev",1,new Date()));
        users.add(new User("Kofi","password","dev",1,new Date()));
        users.add(new User("Ama","password","dev",1,new Date()));

        Mockito.when(userRepository.findAll()).thenReturn(users);

        HashMap<String, Object> theUsers = userService.listUsers();
        assertEquals(2, theUsers.size());

    }

    @Test
    void findUserById() {

        User newUser = new User();
        newUser.setId(3L);
        newUser.setUserName("KwameKert");
        newUser.setPassword("password");

        Optional<User> optionalUser = Optional.of(newUser);
        Mockito.when(userRepository.findById(2L)).thenReturn(optionalUser);

        HashMap<String, Object> foundUser = userService.findUserById(2L);
        Optional<User> extractedUser = (Optional<User>) foundUser.get("data");
        assertEquals("KwameKert",extractedUser.get().getUserName());

    }

    @Test
    void updateUser() {
        User user = new User();
        user.setUserName("KwameKert");
        user.setPassword("password");
        user.setId(23L);
        user.setRole("admin");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        //old user here
        User oldUser = new User("Kwame","password","admin",1, new Date());
        oldUser.setId(1L);

        User newUserUpdate = new User();
        newUserUpdate.setUserName("Dennis");
        newUserUpdate.setRole("dev");
        newUserUpdate.setId(1L);

        //mock findById
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(oldUser));

        //findUser
        //HashMap<String, Object> foundUser = userService.findUserById(1L);

        //extract found user
        //Optional<User> extractedUser = (Optional<User>) foundUser.get("data");

       // User updateUser = extractedUser.get();

        //mock save method
       // Mockito.when(userRepository.save(newUserUpdate)).thenReturn(newUserUpdate);

        HashMap<String, Object> foundUser = userService.updateUser(newUserUpdate);

        User tUser  =(User) foundUser.get("data");
        System.out.println(tUser.getUserName());

//      HashMap<String, Object> updatedUser = userService.updateUser(updateUser);
//
//      User extractUpdatedUser = (User) updatedUser.get("data");
//
//      assertEquals("Dennis", extractUpdatedUser.getUserName());

    }

    @Test
    void deleteUser() {
    }
}