package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findBydepartmentCode(int departmentCode );
}
