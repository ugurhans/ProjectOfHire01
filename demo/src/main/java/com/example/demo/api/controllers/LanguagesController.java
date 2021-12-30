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

import com.example.demo.business.abstracts.LanguageService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Language;



@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return languageService.add(language);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Language language) {
		return languageService.update(language);
	}

	@GetMapping("/getAll")
	public DataResult<List<Language>> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Language> getById(@RequestParam int id) {
		return languageService.getById(id);
	}

}
