package com.todo.springboot.first_project.login;

import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {
	
	private Userrepo userrepo;
	public Userserviceimpl(Userrepo userrepo) {
		this.userrepo=userrepo;
		
	}

	@Override
	public void save(User user) {
		userrepo.save(user);
	}


	@Override
	public String findPasswordByUsername(String username) {
		return userrepo.findPasswordByUsername(username);
	}

	@Override
	public int getuserid(String username) {
		return userrepo.getuserid(username);
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepo.existsByUsername(username);
	}

	@Override
	public User findByuserid(int id) {
		return userrepo.findByuserid(id);
	}

	
}
