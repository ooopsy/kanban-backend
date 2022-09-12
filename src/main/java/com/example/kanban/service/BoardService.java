package com.example.kanban.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.kanban.model.Board;
import com.example.kanban.model.BoardColumn;
import com.example.kanban.repository.BoardColumnRepository;
import com.example.kanban.repository.BoardRepsitory;
import com.example.kanban.util.TokenUtil;

@Service
public class BoardService {

	private BoardRepsitory boardRepository;
	
	private BoardColumnRepository boardColumnRepository;
	
	public BoardService(BoardRepsitory boardRepository, BoardColumnRepository boardColumnRepository) {
		this.boardRepository = boardRepository;
		this.boardColumnRepository = boardColumnRepository;
	}
	
	public List<Board> getBoards() {
		String userId = TokenUtil.getAccessToken().getSubject();
		List<Board> boards = boardRepository.findByUserId(userId, Sort.by(Direction.ASC, "order"));
		return boards;
	}

	public Board saveBoard(Board board) {
		String userId = TokenUtil.getAccessToken().getSubject();
		board.setUserId(userId);
		
		List<BoardColumn> columns = board.getColumns();
		if (ObjectUtils.isEmpty(board.getId()) ) {
			board.setColumns(null);
		}
		
		Board newBoard = boardRepository.save(board);
		newBoard.setColumns(new ArrayList<>());
		for (BoardColumn column : columns) {
			column.setBoardId(newBoard.getId());
			newBoard.getColumns().add(boardColumnRepository.save(column));
		}
		
		return newBoard;
	}

	public void deleteBoard(String id) {
		Board board = boardRepository.findById(id).get();
		List<BoardColumn> columns = board.getColumns();
		for (BoardColumn boardColumn : columns) {
			boardColumnRepository.delete(boardColumn);
		}
		
		boardRepository.delete(board);
	}

	public Board getBoard(String id) {
		return boardRepository.findById(id).get();
	}
	
}
