package com.example.todoproject.service;

import com.example.todoproject.dto.CreateTaskDTO;
import com.example.todoproject.dto.TaskResponseDTO;
import com.example.todoproject.dto.UpdateTaskDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(CreateTaskDTO dto);

    TaskResponseDTO updateTask(Long id, UpdateTaskDTO dto);

    void deleteTask(Long id);

    TaskResponseDTO getTaskById(Long id);

    List<TaskResponseDTO> getAllTasks();
}
