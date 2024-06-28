package com.resultmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarksDTO {
    private String studentId;
    private String subjectId;
    private int obtainedTheoryMarks;
    private int obtainedPracticalMarks;
    private int totalMarks;
}
