package com.resultmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarksDTO {
    private Long id;
    private String studentId;
    private String subjectId;
    private int obtainedTheoryMarks;
    private int obtainedPracticalMarks;
    private int totalMarks;
}
