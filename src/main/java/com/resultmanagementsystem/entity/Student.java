package com.resultmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private String roll;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String std;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String[] roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_subjects",
            joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "roll") },
            inverseJoinColumns = { @JoinColumn(name = "subjects", referencedColumnName = "subjectId")})
    private List<Subject> subjects;
}
