package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Resume;



public interface ResumeDao extends JpaRepository<Resume, Integer> {

	Resume getByCandidate_Id(int candidateId);
	
	Resume getByCoverLetter_Id(int coverLetterId);

}
