package com.example.demo.service;

import com.example.demo.dto.schoolDataDTO;
import com.example.demo.model.schoolData;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public List<Department> getAllDepartment(){ return departmentRepository.findAll(); }
    public List<Professor> getAllProfessor(){ return professorRepository.findAll(); }

    public List<Course> fetchCoursesFromDatabase(){
        List<Course> courseList = getAllCourse().stream().collect(Collectors.toList());
        return courseList;
    }

    public List<Professor> fetchCProfessorsFromDatabase(){
        List<Professor> courseList = getAllProfessor().stream().collect(Collectors.toList());
        return courseList;
    }

    public List<Department> fetchCDepartmentsFromDatabase(){
        List<Department> courseList = getAllDepartment().stream().collect(Collectors.toList());
        return courseList;
    }

    public List<schoolData> getSchoolData(){
        List<Course> courseList = fetchCoursesFromDatabase();
        List<Professor> professorList = fetchCProfessorsFromDatabase();
        List<Department> departmentList = fetchCDepartmentsFromDatabase();

        schoolData courseTable = new schoolData();
        schoolData professorTable = new schoolData();
        schoolData departmentTable = new schoolData();

        courseTable.setCourses(courseList); courseTable.setType("Courses");
        professorTable.setProfessors(professorList); professorTable.setType("Professors");
        departmentTable.setDepartment(departmentList); departmentTable.setType("Department");

        List<schoolData> schoolDataList = new ArrayList<>();
        schoolDataList.add(courseTable);
        schoolDataList.add(professorTable);
        schoolDataList.add(departmentTable);

        return schoolDataList;
    }
}
