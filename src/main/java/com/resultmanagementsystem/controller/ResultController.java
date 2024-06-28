package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.model.Result;
import com.resultmanagementsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{rollNum}")
    public Result getStudentResult(@PathVariable String rollNum){
        return resultService.getStudentResultByRoll(rollNum);
    }
}
