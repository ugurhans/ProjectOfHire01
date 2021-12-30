package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.entities.User;
import com.example.demo.core.results.DataResult;


import com.example.demo.core.results.SuccessDataResult;

import com.example.demo.dataAccess.abstracts.UserDao;
@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(userDao.getById(id));
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.findByEmail(email));
	}

	


}