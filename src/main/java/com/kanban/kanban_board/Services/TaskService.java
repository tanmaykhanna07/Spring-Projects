package com.kanban.kanban_board.Services;

import com.kanban.kanban_board.Repositories.TaskRepository;
import com.kanban.kanban_board.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElse(null);
    }
    public Task saveTask(Task newtask){
        return taskRepository.save(newtask);
    }
    public void deleteTaskById(Integer id){
        taskRepository.deleteById(id);
    }
    public Task updateTaskById(Task updatedTask,Integer id){
        Task existingTask = taskRepository.findById(id).orElse(null);
        if(existingTask != null){
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setStatus(updatedTask.getStatus());

            return taskRepository.save(existingTask);
        }
        return null;
    }
}
