/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.RepositoryModels;

import com.ProjetFinalDF.ProjetFinal.Models.StudentModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    
    // Methods
    List<StudentModel> findByFirstNameAndLastName(String firstName, String lastName);
    List<StudentModel> findByFirstName(String firstName);
    List<StudentModel> findByLastName(String lastName);
    List<StudentModel> findAll();
    Optional<StudentModel> findById(Long id);
    // Method to add or upgrade a student
    StudentModel save(StudentModel student);
    void deleteById(Long id);  
}
