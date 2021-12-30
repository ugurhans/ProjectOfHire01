package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.Experience;

public interface ExperienceService extends BaseEntityService<Experience> {

	DataResult<List<Experience>> getAllByResumeId(int resumeId);

	DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);

}