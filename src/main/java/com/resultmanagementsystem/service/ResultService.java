package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.MarksDTO;
import com.resultmanagementsystem.model.Result;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.model.SubjectMarks;
import com.resultmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResultService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MarksService marksService;

    public Result getStudentResultByRoll(String id){
        Result result = new Result();
        Student student = studentRepository.findById(id).get();
        result.setStudentName(student.getName());
        result.setStudentId(student.getRoll());
        List<MarksDTO> studentSubjectMarks = marksService.findByStudent(student.getId());
        List<SubjectMarks> subjectMarksList = new ArrayList<>();
        for (MarksDTO marksDTO : studentSubjectMarks){
            SubjectMarks subjectMarks = new SubjectMarks();
            subjectMarks.setSubjectName(marksDTO.getSubjectId());
            subjectMarks.setObtainedTheoryMarks(marksDTO.getObtainedTheoryMarks());
            subjectMarks.setObtainedPracticalMarks(marksDTO.getObtainedPracticalMarks());
            subjectMarks.setTotalMarks(marksDTO.getTotalMarks());
            subjectMarksList.add(subjectMarks);
        }
        result.setSubjectMarks(subjectMarksList);
        return result;
    }
}
