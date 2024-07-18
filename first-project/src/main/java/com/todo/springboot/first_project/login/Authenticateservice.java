package com.todo.springboot.first_project.login;

import org.springframework.stereotype.Component;

@Component
public class Authenticateservice {
	
	private Userserviceimpl userserviceimpl;
	public Authenticateservice(Userserviceimpl userserviceimpl) {
		this.userserviceimpl=userserviceimpl;
	}
	
	public boolean userlogin(User user) {
		//String uname=user.getUsername();
		String password=user.getPassword();
		String vpassword=userserviceimpl.findPasswordByUsername(user.getUsername());
		if(password.equals(vpassword))return true;
		else return false;
	}

	public int getuserid(User user) {
		return userserviceimpl.getuserid(user.getUsername());
	}

	public boolean valute(User user) {
		return userserviceimpl.existsByUsername(user.getUsername());
	}

}
