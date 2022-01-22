package com.example.demoapp.service;

import commons.model.employee.Employee;

import java.util.Map;


public interface EmployeeService {

    Employee save(Employee employee);

    Employee fetchEmployeeById(String id);

    Map<String,Object> fetchEmployeeDetails(String employeeId);

}
