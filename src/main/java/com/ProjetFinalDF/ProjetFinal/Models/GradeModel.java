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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Diana
 */
    @Entity  
    @Table(name = "grades")  
    public class GradeModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "student_id", nullable = false)
        private StudentModel student;

        @ManyToOne
        @JoinColumn(name = "course_id", nullable = false)
        private CourseModel course;

        @Column(nullable = false)
        private Double finalMarks;

        @Column(nullable = false)
        private Integer semester;

        @Column(nullable = false)
        private Integer year;
        
        // Constuctors
        public GradeModel(Long id, StudentModel student, CourseModel course, Double finalMarks, Integer semester, Integer year) {
            this.id = id;
            this.student = student;
            this.course = course;
            this.finalMarks = finalMarks;
            this.semester = semester;
            this.year = year;
        }
        
        public GradeModel() {
            // Empty Contructor
        }

        // Getters
        public Long getId() {
            return id;
        }

        public StudentModel getStudent() {
            return student;
        }

        public CourseModel getCourse() {
            return course;
        }

        public Double getFinalMarks() {
            return finalMarks;
        }

        public Integer getSemester() {
            return semester;
        }

        public Integer getYear() {
            return year;
        }

        // Setters
        public void setId(Long id) {
            this.id = id;
        }

        public void setStudent(StudentModel student) {
            this.student = student;
        }

        public void setCourse(CourseModel course) {
            this.course = course;
        }

        public void setFinalMarks(Double finalMarks) {
            this.finalMarks = finalMarks;
        }

        public void setSemester(Integer semester) {
            this.semester = semester;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        // ToString() Methode
        @Override
        public String toString() {
            return "GradeModel{" + "id=" + id + ", student=" + student + ", course=" + course + ", finalMarks=" + finalMarks + ", semester=" + semester + ", year=" + year + '}';
        }
       
}
