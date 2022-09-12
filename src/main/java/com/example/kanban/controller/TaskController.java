package com.example.kanban.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.model.Task;
import com.example.kanban.service.TaskService;

@RestController
@RequestMapping(value = "/api/v1/tasks")
public class TaskController {

	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}
	
	@DeleteMapping("{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
	
	
}
