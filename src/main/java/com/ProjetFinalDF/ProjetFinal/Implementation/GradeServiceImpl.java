/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Implementation;

import com.ProjetFinalDF.ProjetFinal.Models.GradeModel;
import com.ProjetFinalDF.ProjetFinal.RepositoryModels.GradeRepository;
import com.ProjetFinalDF.ProjetFinal.Interface.GradeService;
import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import com.ProjetFinalDF.ProjetFinal.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diana
 */

@Service
public class GradeServiceImpl implements GradeService{
    
    private GradeRepository gradeRepository;
    
    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeModel> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<GradeModel> findById(Long id) {
        return gradeRepository.findById(id);
    }
    
    @Override
    public List<GradeModel> findByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
    
    @Override
    public List<GradeModel> findByCourseId(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }
    
    @Override
    public List<GradeModel> findBySemester(Integer semester) {
        return gradeRepository.findBySemester(semester);
    }
    
    @Override
    public List<GradeModel> findByYear(Integer year) {
        return gradeRepository.findByYear(year);
    }
    
    @Override
    public GradeModel save(GradeModel student) {
        return gradeRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }

}
