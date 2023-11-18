/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.RepositoryModels;

import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
    
    // Methods
    List<CourseModel> findByCourseName(String courseName);
    List<CourseModel> findByCourseCode(String courseCode);
    List<CourseModel> findAll();
    Optional<CourseModel> findById(Long id);
    // Method to add or upgrade a grade
    CourseModel save(CourseModel student);
    void deleteById(Long id); 
}
