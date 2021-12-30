package com.example.demo.business.concrates;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.business.abstracts.UserActivationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.UserActivationDao;
import com.example.demo.entities.concrates.concretes.UserActivation;
@Service
public class UserActivationManager implements UserActivationService {

	private UserActivationDao userActivationDao;
	private EmailService emailService;

	@Autowired
	public UserActivationManager(UserActivationDao userActivationDao, EmailService emailService) {
		this.userActivationDao = userActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(UserActivation userActivation) {

		userActivation.setActivated(false);
		userActivation.setCode(generateCode());
		userActivation.setIsActivatedDate(LocalDateTime.now());

		userActivationDao.save(userActivation);
		return emailService.sendEmail(userActivation.getUser());
	}

	@Override
	public Result update(UserActivation userActivation) {

		userActivationDao.save(userActivation);
		return new SuccessResult("");
	}

	@Override
	public Result delete(int id) {

		userActivationDao.deleteById(id);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<UserActivation>> getAll() {
		return new SuccessDataResult<List<UserActivation>>(userActivationDao.findAll());
	}

	@Override
	public DataResult<UserActivation> getById(int id) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getById(id));
	}

	@Override
	public DataResult<UserActivation> getByCode(String code) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getByCode(code));
	}

	@Override
	public DataResult<UserActivation> getByUserId(int userId) {
		return new SuccessDataResult<UserActivation>(userActivationDao.getByUser_Id(userId));
	}
	
	@Override
	public DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated) {
		return new SuccessDataResult<List<UserActivation>>(userActivationDao.getByIsActivated(isActivated));
	}


	private String generateCode() {

		UUID code = UUID.randomUUID();

		return code.toString();
	}

}
