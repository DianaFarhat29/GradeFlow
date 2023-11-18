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
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author Diana
 */
@Entity
@Table(name = "students")
public class StudentModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String organisation;
    private String mailingAddress;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String telephone;
    private String fax;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String gender;
    private LocalDate dateBirth;

    public StudentModel(String firstName, String lastName, String organisation, String mailingAddress, String city, String province, String postalCode, String country, String telephone, String fax, String email, String gender, LocalDate dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.organisation = organisation;
        this.mailingAddress = mailingAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.gender = gender;
        this.dateBirth = dateBirth;
    }

        
    public StudentModel() {
        // Empty Contructor
    }
        
    // Getters
        public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }
    
    // ToString() Methode
    @Override
    public String toString() {
        return "StudentModels{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", organisation=" + organisation + ", mailingAddress=" + mailingAddress + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", country=" + country + ", telephone=" + telephone + ", fax=" + fax + ", email=" + email + ", gender=" + gender + ", dateBirth=" + dateBirth + '}';
    }  
    
}
