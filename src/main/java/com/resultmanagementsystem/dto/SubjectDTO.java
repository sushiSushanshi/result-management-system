package com.resultmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private String id;
    private String subjectName;
    private int fullMarks;
    private int theoryMarks;
    private int practicalMarks;
}
