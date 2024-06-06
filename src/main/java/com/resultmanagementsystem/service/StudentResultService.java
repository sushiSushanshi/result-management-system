package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.Result;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentResultService {

    @Autowired
    private StudentRepository studentRepository;

    public Result getStudentResultByRoll(String roll){
        Result result = new Result();
        Student student = studentRepository.findById(roll).get();
        result.setStudentName(student.getName());
        result.setRollNum(student.getRoll());
        List<Subject> subjectMarks = student.getSubjects();
        Map<String, Integer> studentMarks = new HashMap<>();
        for(Subject subject : subjectMarks){
            studentMarks.put(subject.getName().toString(),subject.getMarks());
        }
        result.setSubjectMarks(studentMarks);
        return result;
    }
}
