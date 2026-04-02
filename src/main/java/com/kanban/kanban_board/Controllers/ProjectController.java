package com.kanban.kanban_board.Controllers;

import com.kanban.kanban_board.Repositories.ProjectRepository;
import com.kanban.kanban_board.models.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;
    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id){
        return projectRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Project addProject(@RequestBody Project newProject){
        return projectRepository.save(newProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Integer id){
        projectRepository.deleteById(id);
    }
}
