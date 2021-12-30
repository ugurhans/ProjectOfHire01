package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Experience;



public interface ExperienceDao extends JpaRepository<Experience, Integer> {

	List<Experience> getByResume_Id(int resumeId);

	List<Experience> getByResume_Id(int resumeId, Sort sort);

}
