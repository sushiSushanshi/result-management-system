package com.resultmanagementsystem.controller;

import com.resultmanagementsystem.dto.MarksDTO;
import com.resultmanagementsystem.entity.Marks;
import com.resultmanagementsystem.service.MarksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public String addSubject(@RequestBody Marks marks){
        Marks marks1 = marksService.registerMarks(marks);
        return "Marks of subject successfully saved";
    }

    @GetMapping("/all")
    public List<MarksDTO> getMarksOfAll(){
        List<Marks> marks =marksService.getAllMarks();
        List<MarksDTO> dtoList = new ArrayList<>();
        for(Marks mark: marks){
            MarksDTO marksDTO = modelMapper.map(mark, MarksDTO.class);
            dtoList.add(marksDTO);
        }
        return dtoList;
    }

    @GetMapping("/all/{roll}")
    public List<MarksDTO> getMarksOfStudent(@PathVariable String roll){
        List<Marks> marks = marksService.findByStudent(roll);
        List<MarksDTO> dtoList = new ArrayList<>();
        for(Marks mark : marks){
            MarksDTO marksDTO = modelMapper.map(mark , MarksDTO.class);
            dtoList.add(marksDTO);
        }
        return dtoList;
    }
}
