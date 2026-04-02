package com.kanban.kanban_board.Repositories;

import com.kanban.kanban_board.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
