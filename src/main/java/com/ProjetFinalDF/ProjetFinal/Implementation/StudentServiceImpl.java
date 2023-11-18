/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProjetFinalDF.ProjetFinal.Implementation;

import com.ProjetFinalDF.ProjetFinal.Models.StudentModel;
import com.ProjetFinalDF.ProjetFinal.RepositoryModels.StudentRepository;
import com.ProjetFinalDF.ProjetFinal.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diana
 */

@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;
    
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<StudentModel> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public StudentModel save(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
    
    @Override
    public List<StudentModel> findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
    @Override
    public List<StudentModel> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public List<StudentModel> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }
    
}
