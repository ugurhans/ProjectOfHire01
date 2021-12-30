package com.example.demo.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concrates.concretes.Image;

public interface ImageService extends BaseEntityService<Image> {

	Result upload(int userId, MultipartFile file);

	DataResult<Image> getByUserId(int userId);

}