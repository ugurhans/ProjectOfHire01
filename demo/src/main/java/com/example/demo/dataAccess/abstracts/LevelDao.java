package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Level;





public interface LevelDao extends JpaRepository<Level, Integer>{

}
