/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.RepositoryModels;

import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import com.ProjetFinalDF.ProjetFinal.Models.GradeModel;
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
public interface GradeRepository extends JpaRepository<GradeModel, Long> {
    
    // Methods
    List<GradeModel> findByStudentId(Long studentId);
    List<GradeModel> findByCourseId(Long courseId);
    List<GradeModel> findBySemester(Integer semester);
    List<GradeModel> findByYear(Integer year);
    List<GradeModel> findAll();
    Optional<GradeModel> findById(Long id);
    // Method to add or upgrade a grade
    GradeModel save(GradeModel student);
    void deleteById(Long id);
}
