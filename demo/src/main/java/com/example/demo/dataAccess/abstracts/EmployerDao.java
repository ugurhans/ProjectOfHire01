package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Employer;




public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	List<Employer> getByUserActivation_IsActivated(boolean isActivated);
	
	List<Employer> getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);
	
	List<Employer> getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId, Sort sort);

}
