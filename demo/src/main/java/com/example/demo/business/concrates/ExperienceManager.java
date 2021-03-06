package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ExperienceService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.ExperienceDao;
import com.example.demo.entities.concrates.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {

		experienceDao.save(experience);
		return new SuccessResult("İş deneyimi eklendi.");
	}

	@Override
	public Result update(Experience experience) {

		experienceDao.save(experience);
		return new SuccessResult("İş deneyimi güncellendi.");
	}

	@Override
	public Result delete(int id) {

		experienceDao.deleteById(id);
		return new SuccessResult("İş deneyimi silindi.");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(experienceDao.findAll());
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(experienceDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {

		Sort sort = Sort.by(Sort.Direction.DESC, "terminationDate");

		return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId, sort));
	}

}