package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.MarksDTO;
import com.resultmanagementsystem.dto.StudentDTO;
import com.resultmanagementsystem.dto.SubjectDTO;
import com.resultmanagementsystem.entity.Marks;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.MarksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

    public MarksDTO registerMarks(MarksDTO marksDTO){
        marksDTO.setTotalMarks(marksDTO.getObtainedPracticalMarks()+marksDTO.getObtainedTheoryMarks());
        Marks marks = modelMapper.map(marksDTO, Marks.class);
        StudentDTO studentDTO = studentService.getStudent(marksDTO.getStudentId());
        Student student = modelMapper.map(studentDTO, Student.class);
        marks.setStudent(student);
        SubjectDTO subjectDTO = subjectService.findSubjectById(marksDTO.getSubjectId());
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        marks.setSubject(subject);
        Marks marks1 = marksRepository.save(marks);
        MarksDTO responseMarks = modelMapper.map(marks1, MarksDTO.class);
        return responseMarks;
    }

    public List<MarksDTO> getAllMarks(){
        List<Marks> marks =marksRepository.findAll();
        List<MarksDTO> marksDTOList = new ArrayList<>();
        for(Marks mark: marks){
            MarksDTO marksDTO = modelMapper.map(mark, MarksDTO.class);
            marksDTOList.add(marksDTO);
        }
        return marksDTOList;
    }
}
