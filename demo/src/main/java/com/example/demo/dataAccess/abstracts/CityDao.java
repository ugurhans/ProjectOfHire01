package com.example.demo.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.City;


public interface CityDao extends JpaRepository<City, Integer> {

}
