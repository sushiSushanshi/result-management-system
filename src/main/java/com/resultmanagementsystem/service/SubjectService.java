package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private  StudentService studentService;

    public Subject createSubjectByStudentRollNo(Subject subject){
        Student student = studentService.getStudent(subject.getStudentRoll());
        List<Subject> studentSubjectList = student.getSubjects();
        subjectRepository.save(subject);
        return subject;
    }
}
