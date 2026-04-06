package com.kanban.kanban_board.Repositories;

import com.kanban.kanban_board.enums.Status;
import com.kanban.kanban_board.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    public List<Task> findTaskByStatus(Status status);
    public List<Task> findTaskByTitleContainingIgnoreCase(String keyword);// Translates to: SELECT * FROM tasks WHERE LOWER(title) LIKE LOWER('%keyword%')
    public List<Task> findTaskByStatusOrderByTaskIdAsc(Status status);
    public List<Task> findTaskByProject_ProjectName(String projectName);//SELECT * FROM tasks WHERE projectName = ?
    public boolean existsTaskByProject_ProjectName(String projectName);
}
