package com.example.demo.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.UpdatedEmployer;



public interface UpdatedEmployerDao extends JpaRepository<UpdatedEmployer, Integer> {

	UpdatedEmployer getByEmployer_Id(int employerId);

}
