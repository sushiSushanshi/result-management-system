package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.entity.Marks;
import com.resultmanagementsystem.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping("/register")
    public String addSubject(@RequestBody Marks marks){
        Marks marks1 = marksService.registerMarks(marks);
        return "Marks of subject successfully saved";
    }

    @GetMapping("/all")
    public List<Marks> getMarksOfAll(){
        return marksService.getAllMarks();
    }

//    @GetMapping("/all/{roll}")
//    public List<Marks> getMarksOfStudent(@PathVariable String roll){
//        return marksService.findByStudent(roll);
//    }
}
