package com.example.demo.business.abstracts;

import com.example.demo.core.results.Result;

import com.example.demo.entities.concrates.concretes.Candidate;
import com.example.demo.entities.concrates.concretes.CompanyStaff;
import com.example.demo.entities.concrates.concretes.Employer;

public interface AuthService {
	
	Result resgisterCompanyStaff(CompanyStaff companyStaff, String confirmPassword);

	Result resgisterCandidate(Candidate candidate, String confirmPassword);

	Result resgisterEmployer(Employer employer, String confirmPassword);
}
