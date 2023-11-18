/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.logging.Logger;

/**
 *
 * @author Diana
 */
@Entity
@Table(name = "courses") 
public class CourseModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseCode;

    private String description;
    
    // Constuctors
    public CourseModel(Long id, String courseName, String courseCode, String description) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.description = description;
    }
    
    public CourseModel() {
        // Empty Contructor
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ToString() Methode
    @Override
    public String toString() {
        return "CourseModel{" + "id=" + id + ", courseName=" + courseName + ", courseCode=" + courseCode + ", description=" + description + '}';
    }
  
    
}
