package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.repository.TeacherRepository;
import com.resultmanagementsystem.util.CustomPassworEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        teacher.setPassword(CustomPassworEncoder.passwordEncoder().encode(teacher.getPassword()));
        teacherRepository.save(teacher);
        return teacher;
    }
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
