package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.WorkingTimeService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.WorkingTimeDao;
import com.example.demo.entities.concrates.concretes.WorkingTime;
@Service
public class WorkingTimeManager implements WorkingTimeService {
	
	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		
		workingTimeDao.save(workingTime);
		return new SuccessResult("");
	}

	@Override
	public Result update(WorkingTime workingTime) {
		
		workingTimeDao.save(workingTime);
		return new SuccessResult("");
	}

	@Override
	public Result delete(int id) {
		
		workingTimeDao.deleteById(id);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "time");
		
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(sort));
	}

	@Override
	public DataResult<WorkingTime> getById(int id) {
		return new SuccessDataResult<WorkingTime>(workingTimeDao.getById(id));
	}

}
