package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.JobPostingConfirmationType;



public interface JobPostingConfirmationTypeDao extends JpaRepository<JobPostingConfirmationType, Integer> {

}
