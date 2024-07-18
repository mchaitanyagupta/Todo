package com.todo.springboot.first_project.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Todorepo extends JpaRepository<Todo, Integer> {

	public List<Todo> findAllByuserid(int id);


}
