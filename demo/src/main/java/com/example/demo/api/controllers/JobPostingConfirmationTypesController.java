package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobPostingConfirmationTypeService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.JobPostingConfirmationType;


@RestController
@RequestMapping("/api/jobPostingConfirmationTypes")
@CrossOrigin
public class JobPostingConfirmationTypesController {
	
	private JobPostingConfirmationTypeService jobPostingConfirmationTypeService;

	@Autowired
	public JobPostingConfirmationTypesController(JobPostingConfirmationTypeService jobPostingConfirmationTypeService) {
		this.jobPostingConfirmationTypeService = jobPostingConfirmationTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPostingConfirmationType jobPostingConfirmationType) {
		return jobPostingConfirmationTypeService.add(jobPostingConfirmationType);
	}

	@PutMapping("/update")
	public Result update(@RequestBody JobPostingConfirmationType jobPostingConfirmationType) {
		return jobPostingConfirmationTypeService.update(jobPostingConfirmationType);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPostingConfirmationType>> getAll() {
		return jobPostingConfirmationTypeService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<JobPostingConfirmationType> getById(@RequestParam int id) {
		return jobPostingConfirmationTypeService.getById(id);
	}

}
