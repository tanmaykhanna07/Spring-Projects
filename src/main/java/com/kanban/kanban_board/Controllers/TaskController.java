package com.kanban.kanban_board.Controllers;

import com.kanban.kanban_board.Repositories.TaskRepository;
import com.kanban.kanban_board.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id){
        return taskRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Task saveTask(@RequestBody Task newTask){
        return taskRepository.save(newTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task updatedTask, @PathVariable Integer id){
        Task existingTask = taskRepository.findById(id).orElse(null);

        if(existingTask != null){
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setStatus(updatedTask.getStatus());

            return taskRepository.save(existingTask);
        }

        return null;
    }
}
