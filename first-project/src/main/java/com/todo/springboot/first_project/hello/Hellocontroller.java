package com.todo.springboot.first_project.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller 
public class Hellocontroller {
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "say hello to api";
	}
	
	@RequestMapping("hello-jsp")
	public String hellojsp() {
		return "hello";
	}

}
  