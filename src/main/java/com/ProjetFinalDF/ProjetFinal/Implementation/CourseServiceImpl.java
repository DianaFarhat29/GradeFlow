/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Implementation;

import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import com.ProjetFinalDF.ProjetFinal.RepositoryModels.CourseRepository;
import com.ProjetFinalDF.ProjetFinal.Interface.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diana
 */

@Service
public class CourseServiceImpl implements CourseService{
    
    private CourseRepository courseRepository;
    
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseModel> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<CourseModel> findById(Long id) {
        return courseRepository.findById(id);
    }
    
    @Override
    public List<CourseModel> findByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }
    
    @Override
    public CourseModel save(CourseModel student) {
        return courseRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
    
    @Override
    public List<CourseModel> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }
   
}
