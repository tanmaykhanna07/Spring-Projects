package com.kanban.kanban_board.Services;

import com.kanban.kanban_board.Exceptions.ResourceNotFoundException;
import com.kanban.kanban_board.Repositories.ProjectRepository;
import com.kanban.kanban_board.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Integer id) {
        return projectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The project with ID: " + id + " was not found in the database")
        );
    }//used a lambda expression, java is stupid. It will make a ResourceNotFoundException object in the memory everytime the code is run even if the code is perfect and id exists. To fix this we use lambda expression which is Lazy evaluation which basically says only throw this exception when you are done checking and then only make a ResourceNotFoundException object.

    public Project saveProject(Project newProject) {
        if (newProject.getProjectName() == null || newProject.getProjectName().trim().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }
        String formattedName = newProject.getProjectName().trim().toUpperCase();
        newProject.setProjectName(formattedName);
        if (newProject.getDescription() == null || newProject.getDescription().trim().isEmpty()) {//trim gives null pointer exception if the user completely omits the description field. This will crash the program so always check for null pointer exception while calling such methods.
            newProject.setDescription("No description provided");
        }
        return projectRepository.save(newProject);
    }

    //    public void deleteProjectById(Integer id){
//        if(projectRepository.findById(id).orElse(null) != null){
//            projectRepository.deleteById(id);
//        }else{
//            throw new ResourceNotFoundException("Cannot delete something that does not exist, ID: "+id+" Not found" );
//        } My version was this one. Implementing the better version provided by AI.
//    }
    public void deleteProjectById(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete something that does not exist, ID: " + id + " Not found");
        }
        projectRepository.deleteById(id);
    }
}
