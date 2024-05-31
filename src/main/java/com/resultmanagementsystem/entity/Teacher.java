package com.resultmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Teacher {
    @Id
    private String id;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String[] roles;
}
