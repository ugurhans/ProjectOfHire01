package com.example.demo.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.concrates.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	List<Candidate> getByUserActivation_IsActivated(boolean isActivated);

	Candidate getByIdentityNumber(String identityNumber);

}
