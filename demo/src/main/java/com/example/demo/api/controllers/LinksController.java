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

import com.example.demo.business.abstracts.LinkService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Link;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinksController {

	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		this.linkService = linkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Link link) {
		return linkService.add(link);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Link link) {
		return linkService.update(link);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return linkService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<Link>> getAll() {
		return linkService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Link> getById(@RequestParam int id) {
		return linkService.getById(id);
	}

}
