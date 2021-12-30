package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.UserActivation;

public interface UserActivationDao extends JpaRepository<UserActivation, Integer> {
	
	List<UserActivation> getByIsActivated(boolean isActivated);

	UserActivation getByCode(String code);

	UserActivation getByUser_Id(int userId);

}
