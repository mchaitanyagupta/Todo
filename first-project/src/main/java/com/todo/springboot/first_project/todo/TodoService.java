package com.todo.springboot.first_project.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todoc=0;
	
	private static List<Todo> todos=new ArrayList<>();
	
	static {
		todos.add(new Todo(++todoc,"gupta","Learn Devops",LocalDate.now().plusYears(1),false));
	}
	public List<Todo> returntodos(String username){
		return todos;
	}
	
	public void addtodo(String username,String description,LocalDate date,boolean isdone) {
	todos.add(new Todo(++todoc,username,description,date,isdone));
	}

	public void deletetodo(int id) {
		//todo.getid()==id;
		//todo -> todo.getid()==id
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}
	
	public Todo updatetodo(int id) {
		//todo.getid()==id;
		//todo -> todo.getid()==id
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updatetodoo(@Valid Todo todo) {
		deletetodo(todo.getId());
		todos.add(todo);
		
	}

}
