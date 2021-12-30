package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.UserConfirmation;

public interface UserConfirmationService extends BaseEntityService<UserConfirmation> {

	DataResult<List<UserConfirmation>> getAllByUserId(int userId);
	
	DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);

}
