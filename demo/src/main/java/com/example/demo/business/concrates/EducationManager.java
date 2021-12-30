package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EducationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EducationDao;
import com.example.demo.entities.concrates.concretes.Education;
@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {

		educationDao.save(education);
		return new SuccessResult("Eğitim eklendi.");
	}

	@Override
	public Result update(Education education) {

		educationDao.save(education);
		return new SuccessResult("Eğitim güncellendi.");
	}

	@Override
	public Result delete(int id) {

		educationDao.deleteById(id);
		return new SuccessResult("Eğitim silindi.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(educationDao.findAll());
	}

	@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<Education>(educationDao.getById(id));
	}

	@Override
	public DataResult<List<Education>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {

		Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");

		return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId, sort));
	}

}
