package com.example.demoapp.controller;

import com.example.demoapp.config.EmployeeConfiguration;

import com.example.demoapp.service.EmployeeService;
import commons.model.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeConfiguration employeeConfiguration;

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<?> fetchEmployeeDetails(@PathVariable String id){

        Map<String, Object> employeeDetails = employeeService.fetchEmployeeDetails(id);

        if (employeeDetails==null){
           return ResponseEntity.notFound().build();
        }else {
           return ResponseEntity.ok(employeeDetails);
        }
    }

    @GetMapping("/tier")
    public String getConfig(){
        return employeeConfiguration.getTier();
    }


}
