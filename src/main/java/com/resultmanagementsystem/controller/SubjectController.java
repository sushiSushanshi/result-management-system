package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.SubjectDTO;
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
    public SubjectDTO registerSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.registerSubject(subjectDTO);
    }

    @GetMapping("/all")
    public List<SubjectDTO> getAllSubjects(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public SubjectDTO getSubjetById(@PathVariable String id){
        return subjectService.findSubjectById(id);
    }
    @GetMapping("/name/{name}")
    public SubjectDTO getSubjetByName(@PathVariable String name){
        return subjectService.findBySubjectName(name);
    }
}
