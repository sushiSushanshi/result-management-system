package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.CustomUser;
import com.resultmanagementsystem.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomUserController {
    @Autowired
    private CustomUserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody CustomUser user){
        CustomUser user1 = userService.createUser(user);
        return String.format("user successfully created with userID : %s",user1.getUserId());
    }

    @GetMapping("/all")
    public List<CustomUser> getAllUsers(){
        return userService.getAllUsers();
    }
}
