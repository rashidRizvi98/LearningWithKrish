package com.example.taskservice;

import com.example.taskservice.service.ValidationTaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class, args);
    }

    @Bean
    public ValidationTaskRunner getValidationTaskRunner(){
        return new ValidationTaskRunner();
    }

}
