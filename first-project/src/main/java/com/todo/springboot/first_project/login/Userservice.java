package com.todo.springboot.first_project.login;

public interface Userservice {
	public  void save(User user);
	public String findPasswordByUsername(String username);
	public int getuserid(String username);
	public boolean existsByUsername(String username);
	public User findByuserid(int id);

}
