package com.example.demo.business.abstracts;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationService extends BaseEntityService<JobPostingConfirmation>{
	
	DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId);

}
