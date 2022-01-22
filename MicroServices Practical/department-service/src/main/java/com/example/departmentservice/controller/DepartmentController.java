package com.example.departmentservice.controller;

import com.example.departmentservice.service.DepartmentService;
import commons.model.department.Department;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getDepartment(@PathVariable String departmentId){
        Department department = departmentService.getDepartment(departmentId);

        if (department==null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(department);
    }

}
