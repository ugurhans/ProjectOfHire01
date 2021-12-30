package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.JobTitle;


public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	JobTitle getByTitle(String title);

}
