package com.example.todoproject.dto;

import com.example.todoproject.model.Priority;
import com.example.todoproject.model.Status;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UpdateTaskDTO(

        @Size(max = 100)
        String title,

        @Size(max = 500)
        String description,

        LocalDateTime dueDate,

        Priority priority,

        Status status

) {
}