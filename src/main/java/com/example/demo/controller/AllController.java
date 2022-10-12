package com.example.demo.controller;

import com.example.demo.dto.professorDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.model.schoolData;
import com.example.demo.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllController {
    @Autowired
    AllService allService;

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/schoolData")
    public List<schoolData> schoolDataList(){
        return allService.getSchoolData();
    }

    @GetMapping("/getProfessorDTO")
    public List<professorDTO> getProfessorDTO(){
        return allService.professors();
    }
    @GetMapping("/courseToObjects")
    public ArrayList<Object> CourseObjects(){
        return allService.CourseListToArrayList(allService.getCourses());
    }
}