package com.example.departmentservice.service;

import com.example.departmentservice.repository.DepartmentRepository;
import commons.model.department.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(String departmentId) {
        return departmentRepository.findById(departmentId)
                .orElse(null);
    }
}
