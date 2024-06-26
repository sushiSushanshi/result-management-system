package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.TeacherDTO;
import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TeacherDTO createTeacher(TeacherDTO teacherDTO){
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherDTO.class);
    }
    public List<TeacherDTO> getAllTeachers(){
        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher : teacherList){
            TeacherDTO teacherDTO = modelMapper.map(teacher, TeacherDTO.class);
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }
}
