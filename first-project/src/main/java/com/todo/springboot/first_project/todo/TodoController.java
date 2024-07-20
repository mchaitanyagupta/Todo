package com.todo.springboot.first_project.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.springboot.first_project.login.User;
import com.todo.springboot.first_project.login.Userserviceimpl;

import jakarta.validation.Valid;
/*
 * Author:Chaitanya gupta
 * Date:18-7-2024
 * Todocontroller:addtodo,updatetodo,deletetodos
 * DataSource:MySQL
 */
@Controller
@SessionAttributes("cuser")
public class TodoController {
	private Todoserviceimpl todoserviceimpl;
	private Userserviceimpl userserviceimpl;
	public TodoController(Todoserviceimpl todoservice,Userserviceimpl userserviceimpl) {
		super();
		this.todoserviceimpl = todoservice;
		this.userserviceimpl=userserviceimpl;
	} 
	@RequestMapping(value="todolist")
	public String todolist(@SessionAttribute User cuser,Model model) {
		model.addAttribute("todos", todoserviceimpl.findAllByuserid(cuser.getUserid()));
		return "todos";
	}
	@RequestMapping(value="addtodo", method=RequestMethod.GET)
	public String Addnewtodo(@SessionAttribute User cuser,Model model) {
		Todo ntodo=new Todo();
		ntodo.setUserid(cuser.getUserid()); 
		ntodo.setDone(false);
		model.addAttribute("todo", ntodo);
		return "addtodopage";
	}
	@RequestMapping(value="addtodo", method=RequestMethod.POST)
	public String showAddnewtodo(@ModelAttribute User cuser,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) return "addtodopage";
		todoserviceimpl.save(todo);
		return "redirect:todolist";
	}
	@RequestMapping(value="deletetodo")
	public String deletetodo(@RequestParam int id) {
		todoserviceimpl.deletetodo(id);
		return "redirect:todolist";
	}
	@RequestMapping(value="updatetodo")
	public String showupdatetodopage(@RequestParam int id,Model model) {
		Todo todo=todoserviceimpl.updatetodo(id);
		model.addAttribute("todo", todo);
		return "addtodopage";
	}
	@RequestMapping(value="updatetodo", method=RequestMethod.POST)
	public String updatetodo(@ModelAttribute String name,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) return "addtodopage";
		//todo.setUsername(name);
		todoserviceimpl.updatetodoo(todo);
		return "redirect:todolist";
	}
	@GetMapping("dashboard")
	public String showdasboard(@RequestParam int userid,Model model) {
		int uid=userid;
		User cuser=userserviceimpl.findByuserid(uid);
		model.addAttribute("cuser", cuser);
		model.addAttribute("name",cuser.getUsername());
		return "welcome";  
	}
	@GetMapping("home")
	public String tohome(@SessionAttribute User cuser) {
		return "redirect:dashboard?userid="+cuser.getUserid();
	}
	@GetMapping("logout")
	public String logoutpage(@ModelAttribute User cuser) {
		return "logout";
	}
}
