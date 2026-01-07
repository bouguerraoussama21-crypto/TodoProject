package com.example.todoproject.service;

import com.example.todoproject.dto.CreateTaskDTO;
import com.example.todoproject.dto.TaskResponseDTO;
import com.example.todoproject.dto.UpdateTaskDTO;
import com.example.todoproject.exception.TaskNotFoundException;
import com.example.todoproject.mapper.TaskMapper;
import com.example.todoproject.model.Task;
import com.example.todoproject.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDTO createTask(CreateTaskDTO dto) {
        // convert DTO to entity
        Task task = TaskMapper.toEntity(dto);
        // Save the task in the database
        Task saved = taskRepository.save(task);
        // Convert the saved entity back to DTO
        return TaskMapper.toResponse(saved);
     }

    @Override
    public TaskResponseDTO updateTask(Long id, UpdateTaskDTO dto) {
        // Fetch the task or throw 404 if not found
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        // Update only fields provided by the client
        TaskMapper.updateEntity(task, dto);
        // Persist the updated task
        Task updated = taskRepository.save(task);
        // Return updated task as DTO
        return TaskMapper.toResponse(updated);
    }


    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return TaskMapper.toResponse(task);    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
    }

}
