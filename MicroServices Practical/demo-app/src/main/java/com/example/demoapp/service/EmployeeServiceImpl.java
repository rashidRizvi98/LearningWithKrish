package com.example.demoapp.service;


import com.example.demoapp.repository.EmployeeRepository;
import commons.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee fetchEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            return employee.get();
        }
        return null;

    }
}
