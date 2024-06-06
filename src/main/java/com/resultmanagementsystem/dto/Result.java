package com.resultmanagementsystem.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    private String studentName;
    private String rollNum;
    private Map<String, Integer> subjectMarks;
}
