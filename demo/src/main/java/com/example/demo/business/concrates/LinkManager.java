package com.example.demo.business.concrates;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.example.demo.business.abstracts.LinkService;
import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.LinkDao;
import com.example.demo.entities.concrates.concretes.Link;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {

		linkDao.save(link);
		return new SuccessResult("Link eklendi.");
	}

	@Override
	public Result update(Link link) {

		linkDao.save(link);
		return new SuccessResult("Link güncellendi.");
	}

	@Override
	public Result delete(int id) {

		linkDao.deleteById(id);
		return new SuccessResult("Link silindi.");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(linkDao.findAll());
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(linkDao.getById(id));
	}

}