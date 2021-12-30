package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Education;



public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> getByResume_Id(int resumeId);

	List<Education> getByResume_Id(int resumeId, Sort sort);

}
