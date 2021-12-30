package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntityService<CoverLetter> {

	DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);


}
