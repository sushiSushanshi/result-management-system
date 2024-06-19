package com.resultmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Marks {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student Student;
    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject Subject;
    private int obtainedTheoryMarks;
    private int obtainedPracticalMarks;
    private int totalMarks;
}
