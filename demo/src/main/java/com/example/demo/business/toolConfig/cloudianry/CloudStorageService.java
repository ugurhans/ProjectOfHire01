package com.example.demo.business.toolConfig.cloudianry;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.core.results.DataResult;

public interface CloudStorageService {

	DataResult<?> upload(MultipartFile multipartFile);
	
	DataResult<?> delete(String publicIdOfImage);

}