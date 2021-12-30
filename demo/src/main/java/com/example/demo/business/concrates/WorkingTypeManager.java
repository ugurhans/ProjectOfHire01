package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.WorkingTypeService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.WorkingTypeDao;
import com.example.demo.entities.concrates.concretes.WorkingType;
@Service
public class WorkingTypeManager implements WorkingTypeService {
	
	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult("");
	}

	@Override
	public Result update(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult("");
	}

	@Override
	public Result delete(int id) {
		
		workingTypeDao.deleteById(id);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "type");
		
		return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll(sort));
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		return new SuccessDataResult<WorkingType>(workingTypeDao.getById(id));
	}

}
