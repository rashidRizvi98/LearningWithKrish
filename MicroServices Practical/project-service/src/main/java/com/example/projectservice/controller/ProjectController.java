package com.example.projectservice.controller;

import com.example.projectservice.service.ProjectService;
import commons.model.project.Project;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody Project project){
       return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> gerProject(@PathVariable String projectId){
        Project project = projectService.getProject(projectId);

        if (project==null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(project);
    }

}
