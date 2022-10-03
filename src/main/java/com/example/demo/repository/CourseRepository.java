package com.example.demo.repository;

import com.example.demo.dto.courseDTO;
import com.example.demo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

    //JPQL bases on the classes you've created not based on the tables or database
    @Query("select s from Student s where s.emailId = ?1 ")
    Course getByEmail(String EmailId);



}