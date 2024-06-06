package com.resultmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subject {
    @Id
    private String subjectId;
    @Enumerated(EnumType.STRING)
    private Subjects name;
    @Column(name = "student_roll")
    private String studentRoll;
    private int marks;
}
