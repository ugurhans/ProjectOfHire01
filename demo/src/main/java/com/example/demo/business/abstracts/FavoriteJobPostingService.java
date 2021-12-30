package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.FavoriteJobPosting;
import com.example.demo.entities.concrates.concretes.JobPosting;

public interface FavoriteJobPostingService extends BaseEntityService<FavoriteJobPosting> {
	
	DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId);

	DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId);
	
	DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId);

}