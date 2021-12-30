package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserConfirmationTypeService;
import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.UserConfirmationTypeDao;
import com.example.demo.entities.concrates.concretes.UserConfirmationType;
@Service
public class UserConfirmationTypeManager implements UserConfirmationTypeService{
	
	private UserConfirmationTypeDao userConfirmationTypeDao;
	
	@Autowired
	public UserConfirmationTypeManager(UserConfirmationTypeDao userConfirmationTypeDao) {
		this.userConfirmationTypeDao = userConfirmationTypeDao;
	}

	@Override
	public Result add(UserConfirmationType userConfirmationType) {
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay tipi eklendi.");
	}

	@Override
	public Result update(UserConfirmationType userConfirmationType) {
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay tipi güncellendi.");
	}

	@Override
	public Result delete(int id) {
		
		userConfirmationTypeDao.deleteById(id);
		return new SuccessResult("Onay tipi silindi.");
	}

	@Override
	public DataResult<List<UserConfirmationType>> getAll() {
		return new SuccessDataResult<List<UserConfirmationType>>(userConfirmationTypeDao.findAll());
	}

	@Override
	public DataResult<UserConfirmationType> getById(int id) {
		return new SuccessDataResult<UserConfirmationType>(userConfirmationTypeDao.getById(id));
	}

}