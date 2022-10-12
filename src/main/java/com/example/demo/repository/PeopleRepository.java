package com.example.demo.repository;

import com.example.demo.entity.Professor;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

            public static void main (String[] args) {
//                Professor p = new Professor();
//                Professor p2 = new Professor();
//                Professor p3 = new Professor();
//                Professor p4 = new Professor();
//
//                List<Professor> people = new ArrayList<>(); //create LIST

//                    p.setId(1);
//                    p.setFirstname("spencer");
//                    p.setLastname("robles");
//                    p.setDepartmentCode(1000);
//
//                    p2.setId(2);
//                    p2.setFirstname("christian");
//                    p2.setLastname("bonilla");
//                    p2.setDepartmentCode(2000);
//
//                    p3.setId(3);
//                    p3.setFirstname("Ken");
//                    p3.setLastname("Lavina");
//                    p3.setDepartmentCode(3000);
//
//                    p4.setId(4);
//                    p4.setFirstname("Kurt");
//                    p4.setLastname("Suarez");
//                    p4.setDepartmentCode(4000);
//
//                    people.add(p);
//                people.add(p2);
//                people.add(p3);
//                people.add(p4);
//
//                List<Professor> OddPeople = new ArrayList<>();
//                List<Professor> EvenPeople = new ArrayList<>();
//
//                for(Professor x : people){
//                    if(x.getId() %2 ==0){
//                        EvenPeople.add(x);
//                    }
//                    else if( x.getId()%2 !=0){
//                        OddPeople.add(x);
//                    }
//                }
//
//                System.out.println("Even People"+ EvenPeople);
//                System.out.println("Odd People"+ OddPeople);

                    for (int row=1;row<=10;row++){
                        for(int column =1;column <=10;column++){
                            if(column == 1 || column==10 || row == 1 || row ==10) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
    }
}