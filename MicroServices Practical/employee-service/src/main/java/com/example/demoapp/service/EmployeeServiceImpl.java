package com.example.demoapp.service;


import com.example.demoapp.repository.EmployeeRepository;

import commons.model.department.Department;
import commons.model.employee.Employee;
import commons.model.project.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;




    HttpHeaders headers = new HttpHeaders();

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee fetchEmployeeById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            return employee.get();
        }
        return null;

    }

    @Override
    public Map<String,Object> fetchEmployeeDetails(String employeeId) {
        Map<String,Object> employeeDetails=new HashMap<>();
        Employee employee = fetchEmployeeById(employeeId);

        if (employee==null)
            return null;

        employeeDetails.put("primary",employee);

        employeeDetails.put("department", getDepartment(employee.getDepartmentId()));

        employeeDetails.put("project",getProject(employee.getCurrentProjectId()));

        return employeeDetails;
    }

    private Object getDepartment(String departmentId){

        JwtAuthenticationToken token=(JwtAuthenticationToken) SecurityContextHolder
                .getContext()
                .getAuthentication();

        headers.add("Authorization" , "Bearer "+token.getToken().getTokenValue());
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        CircuitBreaker circuitBreaker=circuitBreakerFactory.create("department_breaker");
        return circuitBreaker.run(() -> restTemplate
                .exchange("http://department-service/api/v1/department/" + departmentId
                        ,HttpMethod.GET,entity, Department.class).getBody(), throwable -> getFallback("Could not retrieve department at the moment"));
    }

    private Object getProject(String projectId){
        JwtAuthenticationToken token=(JwtAuthenticationToken) SecurityContextHolder
                .getContext()
                .getAuthentication();

        headers.add("Authorization" , "Bearer "+token.getToken().getTokenValue());
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        CircuitBreaker circuitBreaker=circuitBreakerFactory.create("project_breaker");
       return circuitBreaker.run(() -> restTemplate
                .exchange("http://project-service/api/v1/project/" + projectId
                        , HttpMethod.GET,entity, Project.class).getBody(), throwable -> getFallback("Could not retrieve project at the moment"));

    }

    private String getFallback(String s) {
        return s;
    }
}
