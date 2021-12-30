package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Link;



public interface LinkDao extends JpaRepository<Link, Integer> {

}
