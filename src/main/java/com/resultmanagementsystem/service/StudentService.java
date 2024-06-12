package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.StudentRepository;
import com.resultmanagementsystem.repository.SubjectRepository;
import com.resultmanagementsystem.util.CustomPassworEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public Student createStudent(Student student){
        List<Subject> subjectList = student.getSubjects();
        for(Subject subject : subjectList){
            subject.setSubjectId(subject.getSubjectId());
            subjectRepository.save(subject);
        }
        student.setSubjects(subjectList);
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
            subject.setSubjectId(subject.getSubjectId());
            subjectRepository.save(subject);
            subjectList.add(subject);
        }
        student.setSubjects(subjectList);
        studentRepository.save(student);
        return subjects;
    }
}
