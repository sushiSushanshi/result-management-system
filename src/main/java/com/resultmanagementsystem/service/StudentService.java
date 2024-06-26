package com.resultmanagementsystem.service;

import com.resultmanagementsystem.dto.StudentDTO;
import com.resultmanagementsystem.entity.Student;
import com.resultmanagementsystem.entity.Subject;
import com.resultmanagementsystem.repository.StudentRepository;
import com.resultmanagementsystem.repository.SubjectRepository;
import com.resultmanagementsystem.util.CustomPassworEncoder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO createStudent(StudentDTO studentDTO){
        List<Subject> subjectList = studentDTO.getSubjects().stream().map(s -> {
            String subjectId = subjectService.findBySubjectName(s).getId();
            return subjectService.findSubjectById(subjectId);
        }).collect(Collectors.toList());
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setSubjects(subjectList);
        studentRepository.save(student);
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : students){
            List<String> subjectNames = student.getSubjects().stream().map(Subject::getSubjectName).collect(Collectors.toList());
            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
            studentDTO.setSubjects(subjectNames);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public StudentDTO getStudent(String studentId){
        Student student= studentRepository.findById(studentId).get();
        List<String> studentSubjects = convertStudentSubjectToSubjectDTO(student.getSubjects());
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        studentDTO.setSubjects(studentSubjects);
        return studentDTO;
    }

    public List<String> addSubjectToStudent(String studentId, List<String> subjects){
        Student student = studentRepository.findById(studentId).get();
        List<Subject> subjectList = student.getSubjects();
        for(String subject : subjects){
           Subject subjectToBeAdded = subjectRepository.findBySubjectName(subject);
           subjectList.add(subjectToBeAdded);
        }
        student.setSubjects(subjectList);
        studentRepository.save(student);
        return subjects;
    }

    private List<String> convertStudentSubjectToSubjectDTO(List<Subject> subjects){
        return subjects.stream().map(s -> s.getSubjectName()).collect(Collectors.toList());
    }
}
