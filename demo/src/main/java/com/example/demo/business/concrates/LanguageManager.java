package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.business.abstracts.LanguageService;
import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.LanguageDao;
import com.example.demo.entities.concrates.concretes.Language;




@Service
public class LanguageManager implements LanguageService  {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {

		languageDao.save(language);
		return new SuccessResult("Dil eklendi.");
	}

	@Override
	public Result update(Language language) {

		languageDao.save(language);
		return new SuccessResult("Dil güncellendi.");
	}

	@Override
	public Result delete(int id) {

		languageDao.deleteById(id);
		return new SuccessResult("Dil silindi.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "language");
		
		return new SuccessDataResult<List<Language>>(languageDao.findAll(sort));
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(languageDao.getById(id));
	}

}