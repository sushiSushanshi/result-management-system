package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
    public Subject findBySubjectName(String subjectName){
        return subjectRepository.findBySubjectName(subjectName);
    }

    public Subject findSubjectById(String id){
        return subjectRepository.findById(id).get();
    }
}
