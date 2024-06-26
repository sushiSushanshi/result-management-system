package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.TeacherDTO;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@EnableMethodSecurity
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public String createTeacher(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacherDTO1 = teacherService.createTeacher(teacherDTO);
        return "successfully created tescher with id : "+teacherDTO.getId();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<TeacherDTO> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
}
