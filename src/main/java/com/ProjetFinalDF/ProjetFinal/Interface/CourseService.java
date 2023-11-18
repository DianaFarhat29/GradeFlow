/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Interface;

import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diana
 */
public interface CourseService {
    
    // Methods
    List<CourseModel> findByCourseName(String courseName);
    List<CourseModel> findByCourseCode(String courseCode);
    List<CourseModel> findAll();
    Optional<CourseModel> findById(Long id);
    CourseModel save(CourseModel student);
    void deleteById(Long id); 
}
