package com.example.kanban.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kanban.model.Board;

public interface BoardRepsitory extends JpaRepository<Board, String>{

	public List<Board> findByUserId(String userId, Sort sort);
}
