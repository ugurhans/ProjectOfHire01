package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.Dtos.ResumeWithAllRelatedEntitiesDto;
import com.example.demo.entities.concrates.concretes.Resume;

public interface ResumeService extends BaseEntityService<Resume> {

	Result addCoverLetterToResume(int resumeId, int coverLetterId);
	
	Result deleteCoverLetterFromResume(int resumeId);

	DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByActivatedCandidate();

	DataResult<Resume> getByCandidateId(int candidateId);

	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);

}