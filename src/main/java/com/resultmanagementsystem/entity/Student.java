package com.resultmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student{
    @Id
    private String id;
    private String roll;
    private String name;
    private String std;
    private String phone;
    private String address;
    private String[] roles;

    @ManyToMany
    @JoinTable(name = "student_subjects",
    joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id")})
    private List<Subject> subjects;
}
