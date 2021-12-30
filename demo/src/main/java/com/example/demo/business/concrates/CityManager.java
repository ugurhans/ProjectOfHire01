package com.example.demo.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CityService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CityDao;
import com.example.demo.entities.concrates.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {

		cityDao.save(city);
		return new SuccessResult("Şehir eklendi.");
	}

	@Override
	public Result update(City city) {

		cityDao.save(city);
		return new SuccessResult("Şehir güncellendi.");
	}

	@Override
	public Result delete(int id) {

		cityDao.deleteById(id);
		return new SuccessResult("Şehir silindi.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "city");
		
		return new SuccessDataResult<List<City>>(cityDao.findAll(sort));
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(cityDao.getById(id));
	}

}
