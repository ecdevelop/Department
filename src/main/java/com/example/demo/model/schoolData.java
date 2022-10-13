package com.example.demo.model;


import com.example.demo.dto.professorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL) //before converting this object to a JSON format, hides the field that could possibly have null values
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class schoolData {

    private String type;
    private List<Course> courses;
    private List<professorDTO> ListOfPprofessors;
    private List<Department> department;

}
//    List<Object>[] ListOfArrays ;
//    ArrayList<Object> hi;
//    HashMap<String, Object> hashMap = new HashMap<>();
//    void func(){
//        hashMap.put("Professor",hi );
//    }
//    public void setHashMap(String professor, List<Object> departmentList) {
//    }