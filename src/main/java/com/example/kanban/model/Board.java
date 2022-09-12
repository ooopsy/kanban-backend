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
@Table(name = "t_board")
public class Board {
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Id
	private String id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="order_num")
	private Integer order;
	
	@Column(name="user_id")
	private String userId;
	
	@OneToMany(mappedBy = "boardId")
	@OrderBy("order")
	private List<BoardColumn> columns;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public List<BoardColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<BoardColumn> columns) {
		this.columns = columns;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
