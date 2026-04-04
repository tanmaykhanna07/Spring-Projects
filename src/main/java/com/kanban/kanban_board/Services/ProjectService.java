package com.kanban.kanban_board.Services;

import com.kanban.kanban_board.Repositories.ProjectRepository;
import com.kanban.kanban_board.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    public Project getProjectById(Integer id){
        return  projectRepository.findById(id).orElse(null);
    }
    public Project saveProject(Project newProject){
        return projectRepository.save(newProject);
    }
    public void deleteProjectById(Integer id){
        projectRepository.deleteById(id);
    }
}
