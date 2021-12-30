package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.LinkName;



public interface LinkNameDao extends JpaRepository<LinkName, Integer> {

}
