package com.example.demo.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.core.entities.User;




public interface UserDao extends JpaRepository<User , Integer> {

	
	User findByEmail(String email);

	User getById(int userId);
	
	//List<User> findByMailVerifyTrue();
}
