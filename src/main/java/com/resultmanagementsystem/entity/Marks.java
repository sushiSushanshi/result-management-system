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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;
    private int obtainedTheoryMarks;
    private int obtainedPracticalMarks;
    private int totalMarks;
}
