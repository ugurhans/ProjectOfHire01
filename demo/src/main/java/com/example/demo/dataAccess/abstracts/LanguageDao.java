package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Language;





public interface LanguageDao extends JpaRepository<Language, Integer> {

}
