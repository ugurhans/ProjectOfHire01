package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CompanyStaffService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.CompanyStaff;



@RestController
@RequestMapping("/api/companyStaffs")
@CrossOrigin
public class CompanyStaffsController {

	private CompanyStaffService companyStaffService;

	@Autowired
	public CompanyStaffsController(CompanyStaffService companyStaffService) {
		this.companyStaffService = companyStaffService;
	}

	@PutMapping("/update")
	public Result update(@RequestBody CompanyStaff companyStaff) {
		return companyStaffService.update(companyStaff);
	}

	@GetMapping("/getAll")
	public DataResult<List<CompanyStaff>> getAll() {
		return companyStaffService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<CompanyStaff> getById(@RequestParam int id) {
		return companyStaffService.getById(id);
	}

}
