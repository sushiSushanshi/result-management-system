package com.resultmanagementsystem.service;

import com.resultmanagementsystem.entity.Marks;
import com.resultmanagementsystem.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    public Marks registerMarks(Marks marks){
        return marksRepository.save(marks);
    }

    public List<Marks> getAllMarks(){
        return marksRepository.findAll();
    }

    public List<Marks> findByStudent(String roll){
        return marksRepository.findByStudentId(roll);
    }
}
