package com.example.kanban.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.model.Board;
import com.example.kanban.model.Boards;
import com.example.kanban.service.BoardService;

@RestController
@RequestMapping(value = "/api/v1/boards")
public class BoardController {

	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	public Boards getBoards() {
		Boards boards = new Boards();
		boards.setBoards(boardService.getBoards());
		return boards;
	}
	
	@GetMapping("{id}")
	public Board getBoard(@PathVariable String id) {
		return boardService.getBoard(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteBoard(@PathVariable String id) {
		boardService.deleteBoard(id);
	}
	
	@PostMapping
	public Board saveBoard(@RequestBody Board board) {
		return boardService.saveBoard(board);
	}
	
}
