/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

/**
 *
 * @author Diana
 */
@Controller
public class ControllerIndex {

    @GetMapping("/")
    public String signIn() {
        return "signIn";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to our website!");
        return "index";
    }

    @GetMapping("/studentIndex")
    public String student() {
        return "student";
    }

    @GetMapping("/courseIndex")
    public String course() {
        return "course";
    }

    @GetMapping("/gradeIndex")
    public String grade() {
        return "grade";
    }
}

