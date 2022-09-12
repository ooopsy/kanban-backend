package com.example.kanban.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.kanban.model.Subtask;
import com.example.kanban.model.Task;
import com.example.kanban.repository.SubtaskRepository;
import com.example.kanban.repository.TaskRepository;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	private SubtaskRepository subtaskRepository;
	
	public TaskService (TaskRepository taskRepository, SubtaskRepository subtaskRepository) {
		this.taskRepository = taskRepository;
		this.subtaskRepository = subtaskRepository;
	}

	public Task saveTask(Task task) {
		List<Subtask> subtasks = task.getSubtasks();
		if (ObjectUtils.isEmpty(task.getId()) ) {
			task.setSubtasks(null);
		}
		
		Task newTask = taskRepository.save(task);
		newTask.setSubtasks(new ArrayList<>());
		for (Subtask subtask : subtasks) {
			subtask.setTaskId(newTask.getId());
			newTask.getSubtasks().add(subtaskRepository.save(subtask));
		}
		
		return newTask;
	}
	
	public void deleteTask(String id) {
		Task task = taskRepository.findById(id).get();
		List<Subtask> subtasks = task.getSubtasks();
		for (Subtask subtask : subtasks) {
			subtaskRepository.delete(subtask);
		}
		taskRepository.delete(task);
	}
	
}
