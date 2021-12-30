package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Employer;



public interface EmployerService extends BaseEntityService<Employer> {

	Result activate(String code);

	Result confirm(int employerId, int companyStaffId, int userConfirmationTypeId, boolean isConfirmed);
	
	DataResult<List<Employer>> getAllOnesThatWaitingForAccountConfirmation();
	
	DataResult<List<Employer>> getAllOnesThatWaitingForUpdateConfirmation();
	
	DataResult<List<Employer>> getAllByIsActivated(boolean isActivated);
	
	DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);
	
	DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName(boolean isConfirmed, int userConfirmationTypeId);
	
	DataResult<Employer> getOneThatWaitingForUpdateConfirmationById(int id);
	
	DataResult<Employer> getByEmail(String email);
}
