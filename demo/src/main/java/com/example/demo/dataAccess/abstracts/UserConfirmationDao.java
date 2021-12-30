package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.UserConfirmation;



public interface UserConfirmationDao extends JpaRepository<UserConfirmation, Integer> {

	List<UserConfirmation> getByUser_Id(int userId);
	
	List<UserConfirmation> getByIsConfirmedAndUserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);

}
