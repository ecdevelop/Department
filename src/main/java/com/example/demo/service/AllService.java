package com.example.demo.service;

import com.example.demo.dto.courseDTO;
import com.example.demo.dto.professorDTO;
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
import java.util.Arrays;
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

    public List<schoolData> getSchoolData(){ //getschoolapi
        List<Course> courseList = courseRepository.findAll();
        List<professorDTO> professorList = professors();
        List<Department> departmentList = departmentRepository.findAll();

        schoolData professorTable = new schoolData();
        schoolData departmentTable = new schoolData();
        schoolData courseTable = schoolData.builder().courses(courseList).type("Courses").build();
        //courseTable.setCourses(courseList); courseTable.setType("Courses");
        //courseTable.ConvertListToArrayList(courseList);
        professorTable.setProfessors(professorList); professorTable.setType("Professors");
        departmentTable.setDepartment(departmentList); departmentTable.setType("Department");

        List<schoolData> schoolDataList = new ArrayList<>();
        schoolDataList.add(courseTable);
        schoolDataList.add(professorTable);
        schoolDataList.add(departmentTable);

        return schoolDataList;
    }
        public List<Integer> ListOfDepartmentCode(){ //getlistofdepartmentcode
        List<Department> departmentList = departmentRepository.findAll();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i<departmentList.size();i++){
            intList.add(departmentList.get(i).getDepartmentCode());
        }
        return intList;
        }

        public List<professorDTO> professors(){
        List <Integer> codeList = ListOfDepartmentCode();
        List <professorDTO> resList = new ArrayList<>();
        for(int i = 0; i < codeList.size(); i++) {
            Integer departmentCode = codeList.get(i);
        //set values
        professorDTO model = new professorDTO();
        model.setId(professorRepository.findBydepartmentCode(departmentCode).getId());
        model.setFirstname(professorRepository.findBydepartmentCode(departmentCode).getFirstname());
        model.setLastname(professorRepository.findBydepartmentCode(departmentCode).getLastname());
        model.setDepartmentName(departmentRepository.findBydepartmentCode(departmentCode).getDepartmentName());
        resList.add(model);
        }
            return resList;
        }

}
