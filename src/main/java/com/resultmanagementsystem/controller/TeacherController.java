package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@EnableMethodSecurity
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/register")
    public String createtracher(@RequestBody Teacher teacher){
        teacherService.createTeacher(teacher);
        return "successfully created tescher with id : "+teacher.getId();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
}
