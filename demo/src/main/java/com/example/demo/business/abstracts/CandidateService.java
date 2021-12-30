package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Candidate;



public interface CandidateService extends BaseEntityService<Candidate> {

	Result activate(String code);

	DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated);

	DataResult<Candidate> getByIdentityNumber(String identityNumber);

}
