package com.example.todoproject.dto;
import com.example.todoproject.model.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateTaskDTO(

        @NotBlank
        @Size(max = 100)
        String title,

        @Size(max = 500)
        String description,

        LocalDateTime dueDate,

        @NotNull
        Priority priority

) {
}