package com.example.demo.model;


import com.example.demo.dto.courseDTO;
import com.example.demo.dto.professorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.*;


@JsonInclude(JsonInclude.Include.NON_NULL) //before converting this object to a JSON format, hides the field that could possibly have null values
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class schoolData {

    private String type;
    private List<Course> courses;
    private List<professorDTO> professors;
    private List<Department> department;
    private List<courseDTO> courseDTOList;
    public ArrayList<Object> ConvertListToArrayList(List<Course> objects){
        ArrayList<Object> objectArrayList = new ArrayList<>();
                for(Object x: objects  ){
                    objectArrayList.add(x);
                }
                return objectArrayList;
    }

}

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