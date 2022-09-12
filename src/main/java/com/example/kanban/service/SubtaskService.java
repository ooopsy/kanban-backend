package com.example.kanban.service;

import org.springframework.stereotype.Service;

import com.example.kanban.model.Subtask;
import com.example.kanban.repository.SubtaskRepository;

@Service
public class SubtaskService {

	private SubtaskRepository subtaskRepository;  
	
	public SubtaskService(SubtaskRepository subtaskRepository) {
		this.subtaskRepository = subtaskRepository;
	}
	
	public void deleteSubtask(String id) {
		subtaskRepository.deleteById(id);
	}

	public void changeSubtask(String id, Boolean isCompleted) {
		Subtask subtask = subtaskRepository.findById(id).get();
		subtask.setIsCompleted(isCompleted);
		subtaskRepository.save(subtask);
	}

	
}
