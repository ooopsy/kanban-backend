package com.example.kanban;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kanban.model.Board;
import com.example.kanban.repository.BoardRepsitory;

@SpringBootTest
class KanbanApplicationTests {

	@Autowired
	BoardRepsitory boardRepository;
	
	@Test
	void contextLoads() {
		List<Board> boards = boardRepository.findAll();
		boards.forEach(b -> {
			System.out.println("=======================");
			System.out.println(b.getName());
			System.out.println("-----------------------------");
			b.getColumns().forEach(c -> {
				System.out.println(c.getName());
				c.getTasks().forEach(t -> {
					System.out.println("******");
					System.out.println(t.getTitle());
					t.getSubtasks().forEach(st -> {
						System.out.println("***");
						System.out.println(st.getTitle());
					});
					
				});
			});
			System.out.println("=======================");
		});
		
	}

}
