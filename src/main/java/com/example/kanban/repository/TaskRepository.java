package com.example.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kanban.model.Task;

public interface TaskRepository extends JpaRepository<Task, String> {

}
