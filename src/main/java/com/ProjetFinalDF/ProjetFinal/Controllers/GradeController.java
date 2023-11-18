/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Controllers;

import com.ProjetFinalDF.ProjetFinal.Interface.GradeService;
import com.ProjetFinalDF.ProjetFinal.Interface.StudentService;
import com.ProjetFinalDF.ProjetFinal.Interface.CourseService;
import com.ProjetFinalDF.ProjetFinal.Models.CourseModel;
import com.ProjetFinalDF.ProjetFinal.Models.GradeModel;
import com.ProjetFinalDF.ProjetFinal.Models.StudentModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Diana
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;
    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public GradeController(GradeService gradeService, StudentService studentService, CourseService courseService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String listAllGrades(Model model) {
        List<GradeModel> grades = gradeService.findAll();
        List<StudentModel> students = studentService.findAll();
        List<CourseModel> courses = courseService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        model.addAttribute("grades", grades);
        model.addAttribute("grade", new GradeModel()); // For the form
         System.out.println("Number of grades: " + grades.size());
        return "grade"; // // Thymeleaf file to list grades
    }

    // Search methodes
    @GetMapping("/{id}")
    public String findGradeById(@PathVariable Long id, Model model) {
        Optional<GradeModel> grade = gradeService.findById(id);
        model.addAttribute("grade", grade);
        return "grade";
    }

    @GetMapping("/byCourse")
    public String findByCourseId(@RequestParam Long courseId, Model model) {
        List<GradeModel> grades = gradeService.findByCourseId(courseId);
        model.addAttribute("grades", grades);
        return "grade";
    }

    @GetMapping("/byStudent")
    public String findByStudentId(@RequestParam Long studentId, Model model) {
        List<GradeModel> grades = gradeService.findByStudentId(studentId);
        model.addAttribute("grades", grades);
        return "grade";
    }

    @GetMapping("/bySemester")
    public String findBySemesterId(@RequestParam int semester, Model model) {
        List<GradeModel> grades = gradeService.findBySemester(semester);
        model.addAttribute("grades", grades);
        return "grade";
    }

    @GetMapping("/byYear")
    public String findByYear(@RequestParam int year, Model model) {
        List<GradeModel> grades = gradeService.findByYear(year);
        model.addAttribute("grades", grades);
        return "grade";
    }

    @GetMapping("/searchresults")
    public String searchResults(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long studentId,
            @RequestParam(required = false) Long courseId,
            @RequestParam(required = false) Integer semester,
            @RequestParam(required = false) Integer year,
            Model model) {

        List<GradeModel> grades = new ArrayList<>();

        if (id != null) {
            gradeService.findById(id).ifPresent(grades::add);
        } else if (studentId != null) {
            grades = gradeService.findByStudentId(studentId);
        } else if (courseId != null) {
            grades = gradeService.findByCourseId(courseId);
        } else if (semester != null) {
            grades = gradeService.findBySemester(semester);
        } else if (year != null) {
            grades = gradeService.findByYear(year);
        }
        model.addAttribute("grade", new GradeModel());
        model.addAttribute("grades", grades);
        return "grade"; // Thymeleaf file to display search results
    }

    // Display grades
    @GetMapping("/student/{studentId}")
    public String listGradesByStudentId(@PathVariable Long studentId, Model model) {
        List<GradeModel> grades = gradeService.findByStudentId(studentId);
        model.addAttribute("grades", grades);
        return "grade"; // Thymeleaf file to list grades for a specific student
    }

    @GetMapping("/course/{courseId}")
    public String listGradesByCourseId(@PathVariable Long courseId, Model model) {
        List<GradeModel> grades = gradeService.findByCourseId(courseId);
        model.addAttribute("grades", grades);
        return "grade"; // Thymeleaf file to list grades for a specific course
    }

    // Add a grade
    @PostMapping("/add")
    public String addGrade(GradeModel grade) {
        gradeService.save(grade);
        return "redirect:/grade";
    }

    @GetMapping("/addform")
    public String showAddGradeForm(Model model) {

        model.addAttribute("grade", new GradeModel());
        return "grade"; // Thymeleaf file to show add grade form
    }

    // Delete a Grade
    @PostMapping("/delete/{id}")
    public String deleteGrade(@PathVariable Long id) {
        gradeService.deleteById(id);
        return "redirect:/grade";
    }

    @GetMapping("/deleteform/{id}")
    public String showDeleteGradeForm(@PathVariable Long id, Model model) {
        Optional<GradeModel> gradeOpt = gradeService.findById(id);
        if (gradeOpt.isPresent()) {
            model.addAttribute("grade", gradeOpt.get());
            return "grade"; // Thymeleaf file to confirm grade deletion
        }
        return "redirect:/grade";
    }

    // Edit a grade
    @GetMapping("/edit/{id}")
    public String editGradeform(@PathVariable Long id, Model model) {
        Optional<GradeModel> gradesOpt = gradeService.findById(id);
        if (gradesOpt.isPresent()) {
            model.addAttribute("grade", gradesOpt.get());
            return "grade"; // Thymeleaf file to see grade form
        }
        return "redirect:/grade";
    }

    @PostMapping("/update")
    public String updateGrade(GradeModel grade) {
        gradeService.save(grade);
        return "redirect:/grade";
    }

}
