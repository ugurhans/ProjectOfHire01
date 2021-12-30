package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.LanguageLevel;


public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {

}
