package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.JobPostingConfirmation;



public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation, Integer>{
	
	JobPostingConfirmation getByJobPosting_Id(int jobPostingId);

}
