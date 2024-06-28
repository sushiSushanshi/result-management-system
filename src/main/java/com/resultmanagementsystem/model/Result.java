package com.resultmanagementsystem.model;

import com.resultmanagementsystem.entity.Marks;
import lombok.Data;

import java.util.List;

@Data
public class Result {
    private String studentName;
    private String studentId;
    private List<SubjectMarks> subjectMarks;
}
