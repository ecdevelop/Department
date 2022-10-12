package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class professorDTO {

        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String firstname;
        private String lastname;
        private String departmentName;
}