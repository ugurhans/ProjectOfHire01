package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.FavoriteJobPostingService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.FavoriteJobPosting;
import com.example.demo.entities.concrates.concretes.JobPosting;

@RestController
@RequestMapping("/api/favoriteJobPostings")
@CrossOrigin
public class FavoriteJobPostingsController {

	private FavoriteJobPostingService favoriteJobPostingService;

	@Autowired
	public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService) {
		this.favoriteJobPostingService = favoriteJobPostingService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobPosting favoriteJobPosting) {
		return favoriteJobPostingService.add(favoriteJobPosting);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return favoriteJobPostingService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return favoriteJobPostingService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<FavoriteJobPosting> getById(@RequestParam int id) {
		return favoriteJobPostingService.getById(id);
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<FavoriteJobPosting>> getAllByCandidateId(@RequestParam int candidateId) {
		return favoriteJobPostingService.getAllByCandidateId(candidateId);
	}

	@GetMapping("/getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites")
	public DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(@RequestParam int candidateId) {
		return favoriteJobPostingService.getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(candidateId);
	}

}
