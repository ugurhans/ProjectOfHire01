package com.example.demo.business.abstracts;

import com.example.demo.entities.concrates.concretes.JobPosting;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
public interface JobPostingService extends BaseEntityService<JobPosting> {

	Result confirm(int employerId, int companyStaffId, int jobPostingConfirmationTypeId, boolean isConfirmed);

	Result makeActiveOrPassive(int id, boolean isActive);
	
	DataResult<List<JobPosting>> getAllByIsActive(boolean isActive);

	DataResult<List<JobPosting>> getAllActiveOnesByPage(int pageNo, int pageSize);
	
	DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate();

	DataResult<List<JobPosting>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize);

	DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDateTop6();

	DataResult<List<JobPosting>> getAllActiveOnesByEmployerIdSortedByPostingDate(int employerId);
	
	DataResult<List<JobPosting>> getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId);

	DataResult<List<JobPosting>> getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId, int pageNo, int pageSize);
	
	DataResult<List<JobPosting>> getAllOnesThatWaitingForPostingConfirmation();

}