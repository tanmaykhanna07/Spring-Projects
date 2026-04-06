package com.kanban.kanban_board.Controllers;

import com.kanban.kanban_board.Services.TaskService;
import com.kanban.kanban_board.enums.Status;
import com.kanban.kanban_board.models.Project;
import com.kanban.kanban_board.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable Status status){
        return taskService.getTaskByStatus(status);
    }
    @GetMapping("/project/{projectName}")
    public List<Task> getTaskByProjectName(@PathVariable String projectName){
        return taskService.getTaskByProjectName(projectName);
    }
    @PostMapping
    public Task saveTask(@RequestBody Task newTask){
        return taskService.saveTask(newTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTaskById(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task updatedTask, @PathVariable Integer id){
        return taskService.updateTaskById(updatedTask,id);
    }
}
