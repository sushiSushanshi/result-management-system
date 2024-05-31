package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "student successfully created with roll : "+student.getRoll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/notAll")
    public String getStudent(){
        return "its not secured...";
    }
}
