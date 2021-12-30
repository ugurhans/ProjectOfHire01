package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.UserActivation;

public interface UserActivationService extends BaseEntityService<UserActivation> {

	DataResult<UserActivation> getByCode(String code);

	DataResult<UserActivation> getByUserId(int userId);
	
	DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated);

}