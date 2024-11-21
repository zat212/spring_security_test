package com.demosecurity.controller;

import com.demosecurity.model.User;
import com.demosecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String test1(HttpServletRequest request){
        return "Hello World!"+request.getSession().getId();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);

    }


}
