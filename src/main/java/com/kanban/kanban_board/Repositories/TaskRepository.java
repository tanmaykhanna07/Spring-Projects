package com.kanban.kanban_board.Repositories;

import com.kanban.kanban_board.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
