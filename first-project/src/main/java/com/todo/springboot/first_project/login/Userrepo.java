package com.todo.springboot.first_project.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<User, Integer>{
	@Query("SELECT u.password FROM User u WHERE u.username = :username")
	String findPasswordByUsername(@Param("username")String username);
	
	@Query("SELECT u.userid FROM User u WHERE u.username = :username")
	int getuserid(@Param("username")String username);
	
	public boolean existsByUsername(String username);
	
	public User findByuserid(int id);

}
 