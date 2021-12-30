package com.example.demo.business.concrates;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CoverLetterService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CoverLetterDao;
import com.example.demo.entities.concrates.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {

		coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi.");
	}

	@Override
	public Result update(CoverLetter coverLetter) {

		coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı güncellendi.");
	}

	@Override
	public Result delete(int id) {

		coverLetterDao.deleteById(id);
		return new SuccessResult("Ön yazı silindi.");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.findAll());
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(coverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.getByCandidate_Id(candidateId));
	}

}
