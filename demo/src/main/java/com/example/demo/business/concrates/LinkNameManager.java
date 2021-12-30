package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.LinkNameService;

import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.LinkNameDao;
import com.example.demo.entities.concrates.concretes.LinkName;
@Service
public class LinkNameManager implements LinkNameService {

	private LinkNameDao linkNameDao;

	@Autowired
	public LinkNameManager(LinkNameDao linkNameDao) {
		this.linkNameDao = linkNameDao;
	}

	@Override
	public Result add(LinkName linkName) {

		linkNameDao.save(linkName);
		return new SuccessResult("Bağlantı adı eklendi.");
	}

	@Override
	public Result update(LinkName linkName) {

		linkNameDao.save(linkName);
		return new SuccessResult("Bağlantı adı güncellendi.");
	}

	@Override
	public Result delete(int id) {

		linkNameDao.deleteById(id);
		return new SuccessResult("Bağlantı adı silindi.");
	}

	@Override
	public DataResult<List<LinkName>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		
		return new SuccessDataResult<List<LinkName>>(linkNameDao.findAll(sort));
	}

	@Override
	public DataResult<LinkName> getById(int id) {
		return new SuccessDataResult<LinkName>(linkNameDao.getById(id));
	}

}