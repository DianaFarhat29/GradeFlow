/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Interface;

import com.ProjetFinalDF.ProjetFinal.Models.StudentModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diana
 */
public interface StudentService {
    
    // Methods
    List<StudentModel> findByFirstNameAndLastName(String firstName, String lastName);
    List<StudentModel> findByFirstName(String firstName);
    List<StudentModel> findByLastName(String lastName);
    List<StudentModel> findAll();
    Optional<StudentModel> findById(Long id);
    StudentModel save(StudentModel student);
    void deleteById(Long id);  
}
