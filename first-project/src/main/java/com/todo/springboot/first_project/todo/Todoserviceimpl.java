package com.todo.springboot.first_project.todo;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

@Service
public class Todoserviceimpl implements Todoservice{
	private Todorepo todorepo;
	public Todoserviceimpl(Todorepo todorepo) {
		this.todorepo=todorepo;
	}
	public void deletetodo(int id) {
		todorepo.deleteById(id);	
	}
	public Todo updatetodo(int id) {
		return todorepo.findById(id).get();
	}
	public void updatetodoo(@Valid Todo todo) {
		todorepo.deleteById(todo.getId());
		todorepo.save(todo);
	}
	@Override
	public List<Todo> findAllByuserid(int id) {	
		return todorepo.findAllByuserid(id);
	}
	@Override
	public void save(Todo todo) {
		todorepo.save(todo);	
	}
}
