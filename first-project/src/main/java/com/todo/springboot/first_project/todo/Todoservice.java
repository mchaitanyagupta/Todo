package com.todo.springboot.first_project.todo;

import java.util.List;

public interface Todoservice {
	
	public List<Todo> findAllByuserid(int id);
	public void save(Todo todo);
	

}
