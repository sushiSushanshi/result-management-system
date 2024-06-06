package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String createSubjectWithStudentId(@RequestBody Subject subject){
        subjectService.createSubjectByStudentRollNo(subject);
        return subject.getName()+" added to student with roll "+subject.getStudentRoll();
    }
}
