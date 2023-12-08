package com.example.server.repositories;

import com.example.server.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByIdAndAuthor_Id(Long id, Long authorId);
}
