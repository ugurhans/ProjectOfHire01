package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.Education;

public interface EducationService extends BaseEntityService<Education> {
	DataResult<List<Education>> getAllByResumeId(int resumeId);

	DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);

}
