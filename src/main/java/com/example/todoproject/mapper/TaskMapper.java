package com.example.todoproject.mapper;

import com.example.todoproject.dto.CreateTaskDTO;
import com.example.todoproject.dto.TaskResponseDTO;
import com.example.todoproject.dto.UpdateTaskDTO;
import com.example.todoproject.model.Status;
import com.example.todoproject.model.Task;

public class TaskMapper {

    public static Task toEntity(CreateTaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setDueDate(dto.dueDate());
        task.setPriority(dto.priority());
        task.setStatus(Status.PENDING);
        return task;
    }
    public static void updateEntity(Task task, UpdateTaskDTO dto) {

        if (dto.title() != null) {
            task.setTitle(dto.title());
        }
        if (dto.description() != null) {
            task.setDescription(dto.description());
        }
        if (dto.dueDate() != null) {
            task.setDueDate(dto.dueDate());
        }
        if (dto.priority() != null) {
            task.setPriority(dto.priority());
        }
        if (dto.status() != null) {
            task.setStatus(dto.status());
        }
    }
    public static TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

}
