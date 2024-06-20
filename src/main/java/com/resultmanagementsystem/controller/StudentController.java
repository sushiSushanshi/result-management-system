package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.StudentDTO;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableMethodSecurity
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/register")
    public String createStudent( @RequestBody Student student){
        studentService.createStudent(student);
        return "student successfully created with roll : "+student.getRoll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<StudentDTO> getStudents(){
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : students){
            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId){

        return studentService.getStudent(studentId);
    }
    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/addSubject/{studentId}")
    public String addSubjectToStudent(@PathVariable String studentId ,@RequestBody List<Subject> subjects){
        studentService.addSubjectToStudent(studentId,subjects);
        List<String> subjectsList = new ArrayList<>();
        for(Subject subject : subjects){
            subjectsList.add(subject.getSubjectName().toString());
        }
        return String.join(",",subjectsList)+" added to roll "+studentId;
    }

}
