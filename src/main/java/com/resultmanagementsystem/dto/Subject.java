package com.resultmanagementsystem.dto;

import com.resultmanagementsystem.entity.Subjects;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class   Subject {
    private String subjectId;
    @Enumerated(EnumType.STRING)
    private Subjects name;
    private int marks;
}
