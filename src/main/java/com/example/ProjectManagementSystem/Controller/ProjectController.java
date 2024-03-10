package com.example.ProjectManagementSystem.Controller;

import com.example.ProjectManagementSystem.model.Project;
import com.example.ProjectManagementSystem.repository.ProjectRepo;
import com.example.ProjectManagementSystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects(){
        try{
            List<Project> projectList = projectService.getAllProjects();
            if(projectList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projectList,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id){

            Optional<Project> projectdata = projectService.getProjectById(id);
            if(projectdata.isPresent()){
                Project project = projectdata.get();
                return new ResponseEntity<>(project, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        try{
            Project p = projectService.addProject(project);
            return new ResponseEntity<>(p,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProjectById(@RequestBody Project project,@PathVariable("id") int id){
        try{
            projectService.updateProject(project,id);
            return new ResponseEntity<>(project,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<Project> deleteProjectById(@PathVariable("id") int id){
        try{
            projectService.deleteProject(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
