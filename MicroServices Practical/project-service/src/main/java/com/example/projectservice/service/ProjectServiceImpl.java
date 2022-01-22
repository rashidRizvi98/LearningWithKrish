package com.example.projectservice.service;

import com.example.projectservice.repository.ProjectRepository;
import commons.model.project.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(String projectId) {
        return projectRepository.findById(projectId)
                .orElse(null);
    }
}
