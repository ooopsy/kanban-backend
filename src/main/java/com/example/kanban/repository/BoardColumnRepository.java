package com.example.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kanban.model.BoardColumn;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, String>{

}
