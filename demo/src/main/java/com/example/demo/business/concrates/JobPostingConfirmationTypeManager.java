package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobPostingConfirmationTypeService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobPostingConfirmationTypeDao;
import com.example.demo.entities.concrates.concretes.JobPostingConfirmationType;

@Service
public class JobPostingConfirmationTypeManager implements JobPostingConfirmationTypeService {

	private JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao;

	@Autowired
	public JobPostingConfirmationTypeManager(JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao) {
		this.jobPostingConfirmationTypeDao = jobPostingConfirmationTypeDao;
	}

	@Override
	public Result add(JobPostingConfirmationType entity) {
		return new SuccessResult("İş ilanı onay tipi eklendi.");
	}

	@Override
	public Result update(JobPostingConfirmationType entity) {
		return new SuccessResult("İş ilanı onay tipi güncellendi.");
	}

	@Override
	public Result delete(int id) {
		return new SuccessResult("İş ilanı onay tipi silindi.");
	}

	@Override
	public DataResult<List<JobPostingConfirmationType>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirmationType>>(jobPostingConfirmationTypeDao.findAll());
	}

	@Override
	public DataResult<JobPostingConfirmationType> getById(int id) {
		return new SuccessDataResult<JobPostingConfirmationType>(jobPostingConfirmationTypeDao.getById(id));
	}

}