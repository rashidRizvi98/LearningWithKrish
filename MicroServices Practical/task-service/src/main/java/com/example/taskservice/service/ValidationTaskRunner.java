package com.example.taskservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ValidationTaskRunner implements CommandLineRunner {

    @Autowired
    private NameValidationService nameValidationService;


    @Override
    public void run(String... args) throws Exception {

        if (args.length>0){
            System.out.println("Running with arguments");

            if (nameValidationService.validateFirstName(args[0])){
                System.out.println("Valid Name");
            }else {
                System.out.println("Invalid Name");
            }

        }else {
            System.out.println("Running without arguments");
        }
    }
}
