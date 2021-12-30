package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.entities.User;
import com.example.demo.core.results.DataResult;

public interface UserService {

	
	DataResult<List<User>> getAll();

	DataResult<User> getById(int id);

	DataResult<User> getByEmail(String email);
	
}
