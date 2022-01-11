package com.example.demoapp.service;

import commons.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    Employee save(Employee employee);

    Employee fetchEmployeeById(int id);

}
