package com.resultmanagementsystem.entity;

import com.resultmanagementsystem.dto.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
    @ElementCollection
    private List<Subject> subjects;
}
