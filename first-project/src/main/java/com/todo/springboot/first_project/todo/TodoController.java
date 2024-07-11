package com.todo.springboot.first_project.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	
	private TodoService todoservice;
	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}


	@RequestMapping(value="todolist")
	public String todolist(String username,Model model) {
		model.addAttribute("todos", todoservice.returntodos(username));
		return "todos";
	}
	
	@RequestMapping(value="addtodo", method=RequestMethod.GET)
	public String Addnewtodo(Model model) {
		model.addAttribute("todo", new Todo());
		return "addtodopage";
	}
	
	@RequestMapping(value="addtodo", method=RequestMethod.POST)
	public String showAddnewtodo(@ModelAttribute String name,@Valid Todo todo, BindingResult result) {
		//model.addAttribute("todos", todoservice.returntodos(username));
		if(result.hasErrors()) return "addtodopage";
		todoservice.addtodo(name, todo.getDescription(), todo.getTargetdate(), false);
		return "redirect:todolist";
	}
	
	@RequestMapping(value="deletetodo")
	public String deletetodo(@RequestParam int id) {
		todoservice.deletetodo(id);
		return "redirect:todolist";
	}
	
	@RequestMapping(value="updatetodo")
	public String showupdatetodopage(@RequestParam int id,Model model) {
		Todo todo=todoservice.updatetodo(id);
		model.addAttribute("todo", todo);
		return "addtodopage";
	}
	
	@RequestMapping(value="updatetodo", method=RequestMethod.POST)
	public String updatetodo(@ModelAttribute String name,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) return "addtodopage";
		todo.setUsername(name);
		todoservice.updatetodoo(todo);
		return "redirect:todolist";
	}

}
