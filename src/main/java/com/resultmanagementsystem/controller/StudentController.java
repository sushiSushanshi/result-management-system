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
        List<Subject> subjectList = studentDTO.getSubjects().stream().map(s -> {
            String subjectId = subjectService.findBySubjectName(s).getId();
            return subjectService.findSubjectById(subjectId);
        }).collect(Collectors.toList());
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setSubjects(subjectList);
        studentService.createStudent(student);
        return "student successfully created with roll : "+studentDTO.getRoll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/list")
    public List<StudentDTO> getStudents(){
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : students){
            List<String> subjectNames = student.getSubjects().stream().map(Subject::getSubjectName).collect(Collectors.toList());
            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
            studentDTO.setSubjects(subjectNames);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable String studentId){
        Student student= studentService.getStudent(studentId);
        List<String> studentsubjects = student.getSubjects().stream().map(s -> s.getSubjectName()).collect(Collectors.toList());
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        studentDTO.setSubjects(studentsubjects);
        return studentDTO;
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
