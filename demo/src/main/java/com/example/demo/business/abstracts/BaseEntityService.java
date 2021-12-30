package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;

public interface BaseEntityService<T> {
	
	Result add(T entity);

	Result update(T entity);

	Result delete(int id);

	DataResult<List<T>> getAll();

	DataResult<T> getById(int id);
}
