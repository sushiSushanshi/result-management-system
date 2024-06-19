package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @PostMapping("/register")
    public String addSubject(@RequestBody Subject subject){
        Subject subject1 = subjectService.addSubject(subject);
        return subject1.getSubjectName()+" added successfully";
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubject();
    }
}
