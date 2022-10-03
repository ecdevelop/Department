package com.example.demo.repository;

import com.example.demo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
    Professor findBydepartmentCode(int departmentCode );
}
