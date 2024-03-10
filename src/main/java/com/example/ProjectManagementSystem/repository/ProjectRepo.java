package com.example.ProjectManagementSystem.repository;

import com.example.ProjectManagementSystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {

}
