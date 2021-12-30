package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UpdatedEmployerService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.UpdatedEmployerDao;
import com.example.demo.entities.concrates.concretes.UpdatedEmployer;
@Service
public class UpdatedEmployerManager implements UpdatedEmployerService {

	private UpdatedEmployerDao updatedEmployerDao;

	@Autowired
	public UpdatedEmployerManager(UpdatedEmployerDao updatedEmployerDao) {
		this.updatedEmployerDao = updatedEmployerDao;
	}

	@Override
	public Result add(UpdatedEmployer updatedEmployer) {

		updatedEmployerDao.save(updatedEmployer);
		return new SuccessResult("Güncellenmiş işveren eklendi.");
	}

	@Override
	public Result update(UpdatedEmployer updatedEmployer) {

		updatedEmployerDao.save(updatedEmployer);
		return new SuccessResult("Güncellenmiş işveren güncellendi.");
	}

	@Override
	public Result delete(int id) {

		updatedEmployerDao.deleteById(id);
		return new SuccessResult("Güncellenmiş işveren silindi.");
	}

	@Override
	public DataResult<List<UpdatedEmployer>> getAll() {
		return new SuccessDataResult<List<UpdatedEmployer>>(updatedEmployerDao.findAll());
	}

	@Override
	public DataResult<UpdatedEmployer> getById(int id) {
		return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getById(id));
	}

	@Override
	public DataResult<UpdatedEmployer> getByEmployerId(int employerId) {
		return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getByEmployer_Id(employerId));
	}

}