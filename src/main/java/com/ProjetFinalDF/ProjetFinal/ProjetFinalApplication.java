package com.ProjetFinalDF.ProjetFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ProjetFinalDF.ProjetFinal.Models")
public class ProjetFinalApplication {

    public static void main(String[] args) {
            SpringApplication.run(ProjetFinalApplication.class, args);
    }

}
