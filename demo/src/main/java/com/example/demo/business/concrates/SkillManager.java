package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.SkillService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.SkillDao;
import com.example.demo.entities.concrates.concretes.Skill;
@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {

		skillDao.save(skill);
		return new SuccessResult("Yetenek eklendi.");
	}

	@Override
	public Result update(Skill skill) {

		skillDao.save(skill);
		return new SuccessResult("Yetenek güncellendi.");
	}

	@Override
	public Result delete(int id) {

		skillDao.deleteById(id);
		return new SuccessResult("Yetenek silindi.");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(skillDao.findAll());
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(skillDao.getById(id));
	}

}