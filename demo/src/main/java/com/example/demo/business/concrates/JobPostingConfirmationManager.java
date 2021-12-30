package com.example.demo.business.concrates;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.business.abstracts.JobPostingConfirmationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobPostingConfirmationDao;
import com.example.demo.entities.concrates.concretes.JobPostingConfirmation;

@Service
public class JobPostingConfirmationManager implements JobPostingConfirmationService {
	
	private JobPostingConfirmationDao jobPostingConfirmationDao;
	private EmailService emailService;

	@Autowired
	public JobPostingConfirmationManager(JobPostingConfirmationDao jobPostingConfirmationDao, EmailService emailService) {
		this.jobPostingConfirmationDao = jobPostingConfirmationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(JobPostingConfirmation jobPostingConfirmation) {
		
		jobPostingConfirmation.setIsConfirmedDate(LocalDateTime.now());
		
		jobPostingConfirmationDao.save(jobPostingConfirmation);
		emailService.sendEmail(jobPostingConfirmation.getJobPosting().getEmployer());
		return new SuccessResult("Success");
	}

	@Override
	public Result update(JobPostingConfirmation jobPostingConfirmation) {
		
		jobPostingConfirmationDao.save(jobPostingConfirmation);
		return new SuccessResult("Success");
	}

	@Override
	public Result delete(int id) {
		
		jobPostingConfirmationDao.deleteById(id);
		return new SuccessResult("Success");
	}

	@Override
	public DataResult<List<JobPostingConfirmation>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirmation>>(jobPostingConfirmationDao.findAll());
	}

	@Override
	public DataResult<JobPostingConfirmation> getById(int id) {
		return new SuccessDataResult<JobPostingConfirmation>(jobPostingConfirmationDao.getById(id));
	}

	@Override
	public DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId) {		
		return new SuccessDataResult<JobPostingConfirmation>(jobPostingConfirmationDao.getByJobPosting_Id(jobPostingId));
	}

}