package com.movies.movies.controller;

import java.util.List;

import com.google.gson.Gson;
import com.movies.movies.entity.User;
import com.movies.movies.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getAll(){
        return new Gson().toJson(this.userService.findAll());
    }
}
