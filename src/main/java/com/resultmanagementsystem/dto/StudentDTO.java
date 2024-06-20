package com.resultmanagementsystem.dto;

import com.resultmanagementsystem.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String roll;
    private String name;
    private String std;
    private String phone;
    private String address;
    private String[] roles;
    List<String> subjects;
}
