package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.SubjectDTO;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SubjectDTO registerSubject(SubjectDTO subjectDTO){
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        Subject response = subjectRepository.save(subject);
        return modelMapper.map(response , SubjectDTO.class );
    }

    public List<SubjectDTO> getAllSubject(){
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for(Subject subject : subjects){
            SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
            subjectDTOS.add(subjectDTO);
        }
        return subjectDTOS;
    }
    public SubjectDTO findBySubjectName(String subjectName){
        Subject subject = subjectRepository.findBySubjectName(subjectName);
        return modelMapper.map(subject, SubjectDTO.class);
    }

    public SubjectDTO findSubjectById(String id){
        Subject subject = subjectRepository.findById(id).get();
        return modelMapper.map(subject, SubjectDTO.class);
    }
}
