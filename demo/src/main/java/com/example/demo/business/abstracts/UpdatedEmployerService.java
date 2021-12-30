package com.example.demo.business.abstracts;

import com.example.demo.core.results.DataResult;
import com.example.demo.entities.concrates.concretes.UpdatedEmployer;

public interface UpdatedEmployerService extends BaseEntityService<UpdatedEmployer> {

	DataResult<UpdatedEmployer> getByEmployerId(int employerId);

}
