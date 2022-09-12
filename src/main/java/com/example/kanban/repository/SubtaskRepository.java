package com.example.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kanban.model.Subtask;

public interface SubtaskRepository  extends JpaRepository<Subtask, String>{

}
