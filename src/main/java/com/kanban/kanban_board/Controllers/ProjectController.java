package com.kanban.kanban_board.Controllers;

import com.kanban.kanban_board.Services.ProjectService;
import com.kanban.kanban_board.models.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id){
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project saveProject(@RequestBody Project newProject){
        return projectService.saveProject(newProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Integer id){
        projectService.deleteProjectById(id);
    }
}
