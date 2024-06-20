package com.resultmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String[] roles;
}
