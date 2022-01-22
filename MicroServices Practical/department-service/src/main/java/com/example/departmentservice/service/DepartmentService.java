package com.example.departmentservice.service;

import commons.model.department.Department;

public interface DepartmentService {

    public Department createDepartment(Department department);

    public Department getDepartment(String departmentId);
}
