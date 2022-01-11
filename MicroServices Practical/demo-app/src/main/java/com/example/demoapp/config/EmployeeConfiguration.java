package com.example.demoapp.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@AllArgsConstructor
@Configuration
public class EmployeeConfiguration {

    private final Environment environment;

    public String getTier(){
        return environment.getProperty("employee.tier");
    }
}
