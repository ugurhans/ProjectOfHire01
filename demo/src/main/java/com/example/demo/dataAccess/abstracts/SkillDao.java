package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Skill;



public interface SkillDao extends JpaRepository<Skill, Integer> {

}
