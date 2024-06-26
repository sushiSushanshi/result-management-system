package com.resultmanagementsystem.service.security;

import com.resultmanagementsystem.config.CustomUserDetails;
import com.resultmanagementsystem.entity.CustomUser;
import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.repository.CustomUserRepository;
import com.resultmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CustomUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepository.findById(username).get();
        return new CustomUserDetails(user);
    }
}
