package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.business.abstracts.LanguageLevelService;
import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.LanguageLevelDao;
import com.example.demo.entities.concrates.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {

	private LanguageLevelDao languageLevelDao;

	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public Result add(LanguageLevel languageLevel) {

		languageLevelDao.save(languageLevel);
		return new SuccessResult("Dil seviyesi eklendi.");
	}

	@Override
	public Result update(LanguageLevel languageLevel) {

		languageLevelDao.save(languageLevel);
		return new SuccessResult("Dil seviyesi güncellendi.");
	}

	@Override
	public Result delete(int id) {

		languageLevelDao.deleteById(id);
		return new SuccessResult("Dil seviyesi silindi.");
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll());
	}

	@Override
	public DataResult<LanguageLevel> getById(int id) {
		return new SuccessDataResult<LanguageLevel>(languageLevelDao.getById(id));
	}

}
