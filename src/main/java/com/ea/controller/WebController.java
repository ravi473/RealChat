package com.ea.controller;

import com.ea.entity.User;
import com.ea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Users")
public class WebController {

    @Autowired
    private UserService UserService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return UserService.getAllUsers();
    }

//    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
//    public User getUserByName(@PathVariable("email") String email){
//        User user=UserService.getUserByEmail(email);
//        return user;
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
         User user=UserService.getUserById(id);
        return user;
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteUserById(@PathVariable("id") int id){
//        UserService.removeUserById(id);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void deleteUserById(@RequestBody User user){
//        UserService.updateUser(user);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user){
        UserService.insertUser(user);
    }


}
