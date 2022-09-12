package com.example.kanban.service;

import org.springframework.stereotype.Service;

import com.example.kanban.model.BoardColumn;
import com.example.kanban.repository.BoardColumnRepository;

@Service
public class BoardColumnService {

	private BoardColumnRepository columnRepository;
	
	public BoardColumnService (BoardColumnRepository columnRepository) {
		this.columnRepository = columnRepository;
	}
	
	public BoardColumn saveBoard(BoardColumn boardColumn) {
		
		BoardColumn column = columnRepository.save(boardColumn);
		
		return column;
	}

	public void deleteColumn(String id) {
		BoardColumn column = columnRepository.findById(id).get();
		columnRepository.delete(column);
	}
}
