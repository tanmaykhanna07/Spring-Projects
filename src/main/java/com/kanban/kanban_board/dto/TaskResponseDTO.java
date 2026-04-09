package com.kanban.kanban_board.dto;

import com.kanban.kanban_board.enums.Status;
import com.kanban.kanban_board.models.Task;

public class TaskResponseDTO {
    private Integer taskId;
    private String title;
    private Status status;
    private String projectName;

    public TaskResponseDTO(Integer taskId, String title, Status status, String projectName){
        this.taskId = taskId;
        this.title = title;
        this.status = status;
        this.projectName = projectName;
    }

    public Integer getTaskId() {
        return taskId;
    }
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
