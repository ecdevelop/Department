package com.example.demo.model;


import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.*;


@JsonInclude(JsonInclude.Include.NON_NULL) //before converting this object to a JSON format, hides the field that could possibly have null values
@Data
@AllArgsConstructor
@NoArgsConstructor
public class schoolData {

    private String type;
    private List<Course> courses;
    private List<Professor> professors;
    private List<Department> department;
//    List<Object>[] ListOfArrays ;
//    ArrayList<Object> hi;
//    HashMap<String, Object> hashMap = new HashMap<>();
//
//
//    void func(){
//        hashMap.put("Professor",hi );
//    }
//
//    public void setHashMap(String professor, List<Object> departmentList) {
//    }
}
