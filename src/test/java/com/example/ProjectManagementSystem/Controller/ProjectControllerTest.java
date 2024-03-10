package com.example.ProjectManagementSystem.Controller;

import com.example.ProjectManagementSystem.model.Project;
import com.example.ProjectManagementSystem.repository.ProjectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectControllerTest {

    @Autowired
    private ProjectRepo projectrepo;
    @Test
    void getAllProjects() {
        projectrepo.findAll();

    }

    @Test
    void getProjectById() {
        Project p = new Project(123,"give weather report","20july","10july","Weather App");
        projectrepo.save(p);

    }

    @Test
    void addProject() {
        projectrepo.save(new Project(123,"give weather report","20july","10july","Weather App"));
    }

    @Test
    void deleteProjectById() {
        projectrepo.deleteById(123);
    }
}