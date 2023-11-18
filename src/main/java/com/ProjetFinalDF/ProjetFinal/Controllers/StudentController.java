    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.ProjetFinalDF.ProjetFinal.Models.StudentModel; 
import com.ProjetFinalDF.ProjetFinal.Interface.StudentService; 
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Diana
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
 
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public String listAllStudents(Model model) {
        List<StudentModel> students = studentService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("student", new StudentModel()); // For the form
        System.out.println(students);
        return "student"; // // Thymeleaf file to list students
    }
    
    // Add a student
    @PostMapping("/add")
    public String addStudent(@ModelAttribute StudentModel student) {
        studentService.save(student);
        return "redirect:/student";
    }
    
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new StudentModel());
        return "student"; // Thymeleaf file to show add student form
    }
    
    // Delete a student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/student";
    }
    
    @GetMapping("/delete/{id}/confirm")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Optional<StudentModel> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "student/";
        }
        return "redirect:/student";
    }

    // Search a student
    @GetMapping("/search/firstname")
    public String findByFirstName(@RequestParam String firstName, Model model) {
        List<StudentModel> students = studentService.findByFirstName(firstName);
        model.addAttribute("students", students);
        return "student";
    }

    @GetMapping("/search/lastname")
    public String findByLastName(@RequestParam String lastName, Model model) {
        List<StudentModel> students = studentService.findByLastName(lastName);
        model.addAttribute("students", students);
        return "student";
    }
    
     @GetMapping("/search")
    public String findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<StudentModel> students = studentService.findByFirstNameAndLastName(firstName, lastName);
        model.addAttribute("students", students);
        return "student"; // Thymeleaf file to see result of search for students
    }
    
    @GetMapping("/{id}")
    public String findStudentById(@PathVariable Long id, Model model) {
        Optional<StudentModel> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "student"; // Thymeleaf file to see student
        }
        return "redirect:/student";
    }
    
    @GetMapping("/searchform")
    public String showSearchForm() {
        return "student/searchform"; // Thymeleaf file for the search form
    }
    
    // Treat the submission of search form
    @GetMapping("/searchresults")
        public String searchStudents(
            @RequestParam(required = false) String firstName, 
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Long id, 
            Model model) {

            List<StudentModel> students = new ArrayList<>();

            if (id != null) {
                Optional<StudentModel> studentOpt = studentService.findById(id);
                studentOpt.ifPresent(students::add);
            } else if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
                students = studentService.findByFirstNameAndLastName(firstName, lastName);
            } else if (!StringUtils.isEmpty(firstName)) {
                students = studentService.findByFirstName(firstName);
            } else if (!StringUtils.isEmpty(lastName)) {
                students = studentService.findByLastName(lastName);
            }

            model.addAttribute("student", new StudentModel());
            model.addAttribute("students", students);
            return "student"; // Thymeleaf file to display search results
        }

    // Update Student
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Optional<StudentModel> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "student"; // Thymeleaf file to see student form
        }
        return "redirect:/student";
    }
    
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute StudentModel student) {
        studentService.save(student);
        return "redirect:/student";
    }
    
    @GetMapping("/load/{id}")
    public String loadStudent(@PathVariable Long id, Model model) {
        Optional<StudentModel> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "student"; // Thymeleaf file with the student form
        }
        return "redirect:/student";
    }

    
}
