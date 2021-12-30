package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.UserConfirmationService;
import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.UserConfirmation;

@RestController
@RequestMapping("/api/userConfirmations")
@CrossOrigin
public class UserConfirmationsController {

	private UserConfirmationService userConfirmationService;

	@Autowired
	public UserConfirmationsController(UserConfirmationService userConfirmationService) {
		this.userConfirmationService = userConfirmationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<UserConfirmation>> getAll() {
		return userConfirmationService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<UserConfirmation> getById(@RequestParam int id) {
		return userConfirmationService.getById(id);
	}
	
	@GetMapping("/getAllByUserId")
	public DataResult<List<UserConfirmation>> getAllByUserId(@RequestParam int userId) {
		return userConfirmationService.getAllByUserId(userId);
	}
	
	@GetMapping("/getAllByIsConfirmedAndUserConfirmationTypeId")
	public DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(@RequestParam boolean isConfirmed, @RequestParam int userConfirmationTypeId) {
		return userConfirmationService.getAllByIsConfirmedAndUserConfirmationTypeId(isConfirmed , userConfirmationTypeId);
	}
	
}
