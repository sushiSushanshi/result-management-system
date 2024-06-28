package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.MarksDTO;
import com.resultmanagementsystem.service.MarksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public MarksDTO addSubject(@RequestBody MarksDTO marksDTO){
        return  marksService.registerMarks(marksDTO);
    }

    @GetMapping("/all")
    public List<MarksDTO> getMarksOfAll(){
        return marksService.getAllMarks();
    }
}
