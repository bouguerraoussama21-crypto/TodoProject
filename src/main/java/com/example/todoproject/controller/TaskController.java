package com.example.todoproject.controller;

import com.example.todoproject.dto.CreateTaskDTO;
import com.example.todoproject.dto.TaskResponseDTO;
import com.example.todoproject.dto.UpdateTaskDTO;
import com.example.todoproject.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Task API", description = "Gestion des tâches")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Create a new task")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDTO createTask(@Valid @RequestBody CreateTaskDTO dto) {
        return taskService.createTask(dto);
    }

    @Operation(summary = "Update an existing task")
    @PutMapping("/update/{id}")
    public TaskResponseDTO updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskDTO dto) {
        return taskService.updateTask(id, dto);
    }

    @Operation(summary = "Delete a task by id")
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @Operation(summary = "Get a task by id")
    @GetMapping("/get/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping("/getall")
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getAllTasks();
    }
}
