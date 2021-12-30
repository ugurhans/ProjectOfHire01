package com.example.demo.business.abstracts;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.JobTitle;

public interface JobTitleService extends BaseEntityService<JobTitle> {

	DataResult<JobTitle> getByTitle(String title);

}
