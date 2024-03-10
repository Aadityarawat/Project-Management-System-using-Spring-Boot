package com.example.ProjectManagementSystem.service;

import com.example.ProjectManagementSystem.model.Project;
import com.example.ProjectManagementSystem.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getAllProjects(){
        List<Project> list = projectRepo.findAll();
        return list;
    }

    public Optional<Project> getProjectById(int id){
        Optional<Project> project = null;
        try{
            project = projectRepo.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return project;
    }

    public Project addProject(Project p){
            Project result = projectRepo.save(p);
            return result;
    }
    public void deleteProject(int pid){
        try{
            projectRepo.deleteById(pid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProject(Project project, int projectId){
        try{
            project.setId(projectId);
            projectRepo.save(project);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
