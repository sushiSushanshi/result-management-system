package com.resultmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    private String id;
    private String subjectName;
    private int fullMarks;
    private int theoryMarks;
    private int practicalMarks;

    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    private List<Student> students;
}
