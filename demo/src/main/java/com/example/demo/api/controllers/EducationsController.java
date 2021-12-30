package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EducationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Education;



@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return educationService.add(education);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Education education) {
		return educationService.update(education);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return educationService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll() {
		return educationService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Education> getById(@RequestParam int id) {
		return educationService.getById(id);
	}

	@GetMapping("/getAllByResumeIdSortedByGraduationDate")
	public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId) {
		return educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
	}

}
