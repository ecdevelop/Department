package com.example.demo.service;

import com.example.demo.dto.professorDTO;
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

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }
    public List<Professor> getProfessors(){ return professorRepository.findAll();
    }

    public List<schoolData> getSchoolData(){ //getschoolapi
        List<Course> courseList = courseRepository.findAll();
        List<professorDTO> professorDTOList = professors();
        List<Department> departmentList = departmentRepository.findAll();

        schoolData professorTable = new schoolData(); professorTable.setListOfPprofessors(professorDTOList); professorTable.setType("Professors");
        schoolData departmentTable = new schoolData();
        schoolData courseTable = new schoolData();

        departmentTable.setDepartment(departmentList); departmentTable.setType("Department");
        courseTable.setCourses(courseList); courseTable.setType("Courses");

//      schoolData.builder().courses(courseList).type("Courses").build();

        List<schoolData> schoolDataList = new ArrayList<>();
        schoolDataList.add(courseTable);
        schoolDataList.add(professorTable);
        schoolDataList.add(departmentTable);

        return schoolDataList;
    }

        public List<professorDTO> professors(){
        List<Department> departmentList = departmentRepository.findAll();
        List <Integer> codeList = departmentList.stream().map(d->d.getDepartmentCode()).collect(Collectors.toList()); //gets all departmentcode and adds to a list
        List <professorDTO> resList = new ArrayList<>();

        for(int i = 0; i < codeList.size(); i++) {
            Integer departmentCode = codeList.get(i);
        //set values
        professorDTO model = new professorDTO();
        model.setId(professorRepository.findByDepartmentCode(departmentCode).getId());
        model.setFirstname(professorRepository.findByDepartmentCode(departmentCode).getFirstname());
        model.setLastname(professorRepository.findByDepartmentCode(departmentCode).getLastname());
        model.setDepartmentName(departmentRepository.findByDepartmentCode(departmentCode).getDepartmentName());
        resList.add(model);
        }
            return resList;
        }

    public ArrayList<Object> CourseListToArrayList(List<Course> objects) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for (Object x : objects) {
            objectArrayList.add(x);
        }
        return objectArrayList;
    }

    public ArrayList<Object> ProfessorListToArrayList(List<Professor> objects) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for (Object x : objects) {
            objectArrayList.add(x);
        }
        return objectArrayList;
    }

    public ArrayList<Object> DepartmentListToArrayList(List<Department> objects) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for (Object x : objects) {
            objectArrayList.add(x);
        }
        return objectArrayList;
    }

    //        public List<Integer> ListOfDepartmentCode(){ //getlistofdepartmentcode
//        List<Department> departmentList = departmentRepository.findAll().stream().map(d->d).collect(Collectors.toList());
//        List<Integer> intList = new ArrayList<>();
//        for (int i = 0; i<departmentList.size();i++){
//            intList.add(departmentList.get(i).getDepartmentCode());
//        }
//        return intList;
//        }
}
