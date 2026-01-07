package com.example.todoproject.dto;


import com.example.todoproject.model.Priority;
import com.example.todoproject.model.Status;

import java.time.LocalDateTime;

public record TaskResponseDTO(
         Long id,
         String title,
        String description,
        LocalDateTime dueDate,
        Status status,
        Priority priority,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}