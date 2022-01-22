package com.example.projectservice.service;

import commons.model.project.Project;

public interface ProjectService {

    public Project createProject(Project project);

    public Project getProject(String projectId);
}
