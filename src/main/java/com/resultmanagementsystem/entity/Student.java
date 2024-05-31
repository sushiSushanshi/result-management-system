package com.resultmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private String roll;
    private String password;
    private String name;
    private String std;
    private String phone;
    private String address;
    private String[] roles;
}
