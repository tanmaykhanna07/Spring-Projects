package com.kanban.kanban_board.Services;

import com.kanban.kanban_board.Exceptions.ResourceNotFoundException;
import com.kanban.kanban_board.Repositories.ProjectRepository;
import com.kanban.kanban_board.Repositories.TaskRepository;
import com.kanban.kanban_board.enums.Status;
import com.kanban.kanban_board.models.Project;
import com.kanban.kanban_board.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    public TaskService(TaskRepository taskRepository,ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The provided ID: "+ id+ " doesn't exist in the database")
        );
    }

    public List<Task> getTaskByStatus(Status status){
        return taskRepository.findTaskByStatus(status);
    }

    public Task saveTask(Task newTask) {
        if(newTask.getTitle() == null || newTask.getTitle().trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(newTask.getProject() == null || newTask.getProject().getProjectId() == null){
            throw new IllegalArgumentException("Project does not exist. A task cannot exist without the existence of a project. Try again with a valid project");
        }
        Integer projectId = newTask.getProject().getProjectId();
        Project existingProject = projectRepository.findById(projectId).orElseThrow(
                () -> new ResourceNotFoundException("No project found with this Id, Make sure you've entered the correct Id.")
        );
        newTask.setProject(existingProject);
        newTask.setTitle(newTask.getTitle().trim().toUpperCase());
        return taskRepository.save(newTask);
    }

    public void deleteTaskById(Integer id){
        if(!taskRepository.existsById(id)){
            throw new ResourceNotFoundException("ID: " + id+ " not found, couldn't delete");
        }
        taskRepository.deleteById(id);
    }

    public Task updateTaskById(Task updatedTask,Integer id){
        Task existingTask = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The provided ID: "+ id+ " doesn't exist in the database")
        );
        if(updatedTask.getTitle() == null || updatedTask.getTitle().trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }

        updatedTask.setTitle(updatedTask.getTitle().trim().toUpperCase());
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask);
    }
}
