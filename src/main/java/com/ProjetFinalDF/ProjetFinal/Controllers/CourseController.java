/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Controllers;

import com.ProjetFinalDF.ProjetFinal.Interface.CourseService;
import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Diana
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
 
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping
    public String listAllCourses(Model model) {
        List<CourseModel> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new CourseModel()); 
        return "course"; // // Thymeleaf file to list courses
    }
    
    // Add a course
    @PostMapping("/add")
    public String addCourse(CourseModel course) {
        courseService.save(course);
        return "redirect:/course";
    }
    
    @GetMapping("/addform")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new CourseModel());
        return "course"; // Thymeleaf file to show add course form
    }

    
    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return "redirect:/course";
    }
    
    // Search Course
    @GetMapping("/{id}")
    public String findCourseById(@PathVariable Long id, Model model) {
        Optional<CourseModel> courseOpt = courseService.findById(id);
        if (courseOpt.isPresent()) {
            model.addAttribute("course", courseOpt.get());
            return "course"; // Thymeleaf file to see course
        }
        return "redirect:/course";
    }
    
    @GetMapping("/search")
    public String findByName(@RequestParam String courseName, Model model) {
        List<CourseModel> courses = courseService.findByCourseName(courseName);
        model.addAttribute("course", new CourseModel()); 
        model.addAttribute("courses", courses);
        return "course"; // Thymeleaf file to see result of search for courses
    }
    
    @GetMapping("/searchByCode")
    public String findByCourseCode(@RequestParam String courseCode, Model model) {
        List<CourseModel> courses = courseService.findByCourseCode(courseCode);
        model.addAttribute("course", new CourseModel()); 
        model.addAttribute("courses", courses);
        return "course"; // Thymeleaf file to see result of search for courses
    }
    
    @GetMapping("/searchform")
    public String showSearchCourseForm() {
        return "course"; // Thymeleaf file to show search course form
    }
    
    // Treat the submission of search form
    @GetMapping("/searchresults")
    public String searchStudents(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String courseName,
            @RequestParam(required = false) String courseCode,
            Model model) {

        List<CourseModel> courses = new ArrayList<>();

        if (id != null) {
            Optional<CourseModel> courseOpt = courseService.findById(id);
            courseOpt.ifPresent(courses::add);
        } else if (!StringUtils.isEmpty(courseName)) {
            courses = courseService.findByCourseName(courseName);
        } else if (!StringUtils.isEmpty(courseCode)) { // Added condition for courseCode
            courses = courseService.findByCourseCode(courseCode); // Assuming you have a method in your service to find by courseCode
        }

        model.addAttribute("course", new CourseModel());
        model.addAttribute("courses", courses);
        return "course"; // Thymeleaf file to display search results
    }

        
    // Update Course
    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        Optional<CourseModel> courseOpt = courseService.findById(id);
        if (courseOpt.isPresent()) {
            model.addAttribute("course", courseOpt.get());
            return "course"; // Thymeleaf file to see course form
        }
        return "redirect:/course";
    }
    
    @PostMapping("/update")
    public String updateCourse(CourseModel course) {
        courseService.save(course);
        return "redirect:/course";
    }
}
    

