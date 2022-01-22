package com.example.taskservice.service;

import org.springframework.stereotype.Service;

@Service
public class NameValidationServiceImpl implements NameValidationService{
    @Override
    public boolean validateFirstName(String firstName) {

        return firstName.length()>2;
    }
}
