package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.CoverLetter;



public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

	List<CoverLetter> getByCandidate_Id(int candidateId);

}
