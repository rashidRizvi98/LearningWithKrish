package com.example.demoapp.controller;

import com.example.demoapp.config.EmployeeConfiguration;

import com.example.demoapp.service.EmployeeService;
import commons.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeConfiguration employeeConfiguration;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public ResponseEntity<Employee> fetchEmployee(@RequestParam int id){

        Employee employee = employeeService.fetchEmployeeById(id);

        if (employee==null){
           return ResponseEntity.notFound().build();
        }else {
           return ResponseEntity.ok().body(employee);
        }
    }

    @GetMapping("/tier")
    public String getConfig(){
        return employeeConfiguration.getTier();
    }
}
