package com.example.kanban.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_task")
public class Task {
	
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Id
	private String id;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="description")
	private String description;
	
	@Column(name="column_id")
	private String columnId;
	
	@Column(name ="order_num")
	private Integer order;
	
	@OneToMany(mappedBy = "taskId")
	@OrderBy("order")
	List<Subtask> subtasks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Subtask> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(List<Subtask> subtasks) {
		this.subtasks = subtasks;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	
	
	
}
