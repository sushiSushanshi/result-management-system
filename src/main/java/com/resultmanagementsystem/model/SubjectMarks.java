package com.resultmanagementsystem.model;

import lombok.Data;

@Data
public class SubjectMarks {
    private String subjectName;
    private int obtainedPracticalMarks;
    private int obtainedTheoryMarks;
    private int totalMarks;
}
