package com.example.ProjectManagementSystem.service;

import com.example.ProjectManagementSystem.model.Project;
import com.example.ProjectManagementSystem.repository.ProjectRepo;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepo projectRepository;

    @Test
    void getAllProjects() {
        // Retrieve projects from service and repository
        List<Project> projects = projectService.getAllProjects();
        List<Project> projectsFromRepository = projectRepository.findAll();

        // Assert that both lists are equal
        assertEquals(projectsFromRepository.size(), projects.size());
        for (int i = 0; i < projects.size(); i++) {
            assertEquals(projectsFromRepository.get(i), projects.get(i));
        }
    }

    @Test
    void getProjectById() {
        Optional<Project> projects = projectService.getProjectById(1);
        Optional<Project> projectsFromRepository = projectRepository.findById(1);

        // Assert that both lists are equal
        assertEquals(projectsFromRepository, projects);

    }

    @Test
    void addProject() {
        Project p = new Project(3,"give weather report","20july","10july","Weather App");
        Project projects = projectService.addProject(p);
        Project projectsFromRepository = projectRepository.findById(projects.getId()).orElse(null);

        // Assert that both lists are equal
        assertEquals(projects.getId(), projectsFromRepository.getId());
        assertEquals(projects.getName(), projectsFromRepository.getName());
        assertEquals(projects.getStartDate(), projectsFromRepository.getStartDate());
        assertEquals(projects.getEndDate(), projectsFromRepository.getEndDate());
        assertEquals(projects.getDescription(), projectsFromRepository.getDescription());

    }

}