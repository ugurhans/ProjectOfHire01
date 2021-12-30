package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.LevelService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.LevelDao;
import com.example.demo.entities.concrates.concretes.Level;

@Service
public class LevelManager implements LevelService {
	
	private LevelDao levelDao;

	@Autowired
	public LevelManager(LevelDao levelDao) {
		this.levelDao = levelDao;
	}

	@Override
	public Result add(Level level) {
		
		levelDao.save(level);
		return new SuccessResult("");
	}

	@Override
	public Result update(Level level) {
		
		levelDao.save(level);
		return new SuccessResult("");
	}

	@Override
	public Result delete(int id) {
		
		levelDao.deleteById(id);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<Level>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "level");
		
		return new SuccessDataResult<List<Level>>(levelDao.findAll(sort));
	}

	@Override
	public DataResult<Level> getById(int id) {
		return new SuccessDataResult<Level>(levelDao.getById(id));
	}



}
