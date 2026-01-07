package com.example.todoproject.repository;

import com.example.todoproject.model.Priority;
import com.example.todoproject.model.Task;
import com.example.todoproject.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByDueDateBefore(LocalDateTime dateTime);
}
