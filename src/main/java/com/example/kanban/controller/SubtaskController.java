package com.example.kanban.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.service.SubtaskService;

@RestController
@RequestMapping(value = "/api/v1/subtasks")
public class SubtaskController {
	
	private SubtaskService subtaskService;
	
	public SubtaskController(SubtaskService subtaskService) {
		this.subtaskService = subtaskService;
	}
	
	@DeleteMapping("{id}")
	public void deleteSubtask(@PathVariable String id) {
		subtaskService.deleteSubtask(id);
	}
	
	@PostMapping("{id}")
	public void changeSubtask(@PathVariable String id, @RequestParam Boolean isCompleted) {
		subtaskService.changeSubtask(id, isCompleted);
	}
	
}
