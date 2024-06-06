package com.resultmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
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
    @OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_roll", referencedColumnName = "roll")
    private List<Subject> subjects;
}
