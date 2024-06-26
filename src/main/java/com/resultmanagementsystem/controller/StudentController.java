package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.StudentDTO;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.service.StudentService;
import com.resultmanagementsystem.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableMethodSecurity
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/register")
    public String createStudent( @RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
        return "student successfully created with roll : "+studentDTO.getRoll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable String studentId){
        return studentService.getStudent(studentId);
    }
    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/addSubject/{studentId}")
    public List<String> addSubjectToStudent(@PathVariable String studentId ,@RequestBody List<String> subjects){
        return studentService.addSubjectToStudent(studentId, subjects);
    }

}
