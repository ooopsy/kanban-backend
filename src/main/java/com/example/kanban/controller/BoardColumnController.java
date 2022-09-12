package com.example.kanban.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.service.BoardColumnService;

@RestController
@RequestMapping(value = "/api/v1/columns")
public class BoardColumnController {
	
	private BoardColumnService columnService;
	
	public BoardColumnController(BoardColumnService columnService) {
		this.columnService = columnService;
	}
	
	@DeleteMapping("{id}")
	public void deleteColumn(@PathVariable String id) {
		columnService.deleteColumn(id);
	}
	
}
