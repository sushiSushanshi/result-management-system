package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.CustomUser;
import com.resultmanagementsystem.repository.CustomUserRepository;
import com.resultmanagementsystem.util.CustomPassworEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService {
    @Autowired
    private CustomUserRepository customUserRepository;

    public CustomUser createUser(CustomUser user){
        user.setPassword(CustomPassworEncoder.passwordEncoder().encode(user.getPassword()));
        return customUserRepository.save(user);
    }

    public List<CustomUser> getAllUsers(){
        return customUserRepository.findAll();
    }
}
