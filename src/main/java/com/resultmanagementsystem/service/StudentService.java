package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.dto.Subject;
import com.resultmanagementsystem.repository.StudentRepository;
import com.resultmanagementsystem.util.CustomPassworEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        student.setPassword(CustomPassworEncoder.passwordEncoder().encode(student.getPassword()));
        studentRepository.save(student);
        return student ;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(String studentId){
        return studentRepository.findById(studentId).get();
    }

    public List<Subject> addSubjectToStudent(String studentId, List<Subject> subjects){
        Student student = studentRepository.findById(studentId).get();
        List<Subject> subjectList = student.getSubjects();
        for(Subject subject : subjects){
            subjectList.add(subject);
        }
        student.setSubjects(subjectList);
        return subjects;
    }
}
