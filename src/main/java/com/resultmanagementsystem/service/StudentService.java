package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Student;
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
}
