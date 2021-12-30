package com.example.demo.business.concrates;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.FavoriteJobPostingService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.ErrorResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.FavoriteJobPostingDao;
import com.example.demo.entities.concrates.concretes.FavoriteJobPosting;
import com.example.demo.entities.concrates.concretes.JobPosting;


@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService {

	private FavoriteJobPostingDao favoriteJobPostingDao;

	@Autowired
	public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao) {
		this.favoriteJobPostingDao = favoriteJobPostingDao;
	}

	@Override
	public Result add(FavoriteJobPosting favoriteJobPosting) {
		
		if (getByCandidateIdAndJobPostingId(favoriteJobPosting.getCandidate().getId(), favoriteJobPosting.getJobPosting().getId()).getData() == null) {
			favoriteJobPosting.setDateOfAddToFavorites(LocalDateTime.now());
			favoriteJobPostingDao.save(favoriteJobPosting);
			
			return new SuccessResult("İlan favorilere eklendi.");
		}
		
		return new ErrorResult("Hata");
	}

	@Override
	public Result update(FavoriteJobPosting favoriteJobPosting) {
		
		favoriteJobPostingDao.save(favoriteJobPosting);
		return new SuccessResult("Success");
	}

	@Override
	public Result delete(int id) {
		
		favoriteJobPostingDao.deleteById(id);
		return new SuccessResult("İlan favorilerden kaldırıldı.");
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return new SuccessDataResult<List<FavoriteJobPosting>>(favoriteJobPostingDao.findAll());
	}

	@Override
	public DataResult<FavoriteJobPosting> getById(int id) {
		return new SuccessDataResult<FavoriteJobPosting>(favoriteJobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<FavoriteJobPosting>>(favoriteJobPostingDao.getByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId) {
		
		List<JobPosting> jobPostings = new ArrayList<JobPosting>();

		Sort sort = Sort.by(Sort.Direction.DESC, "dateOfAddToFavorites");
		
		for (FavoriteJobPosting favoriteJobPosting : favoriteJobPostingDao.getByCandidate_Id(candidateId, sort)) {
			if (favoriteJobPosting.getJobPosting().isActive()) {
				jobPostings.add(favoriteJobPosting.getJobPosting());
			} else {
				delete(favoriteJobPosting.getId());
			}
		}		
		
		return new SuccessDataResult<List<JobPosting>>(jobPostings);
	}

	@Override
	public DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId) {
		return new SuccessDataResult<FavoriteJobPosting>(favoriteJobPostingDao.getByCandidate_IdAndJobPosting_Id(candidateId, jobPostingId));
	}

}