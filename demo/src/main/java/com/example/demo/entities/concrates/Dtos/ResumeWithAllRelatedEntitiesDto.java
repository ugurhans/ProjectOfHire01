package com.example.demo.entities.concrates.Dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entities.concrates.concretes.Candidate;
import com.example.demo.entities.concrates.concretes.CoverLetter;
import com.example.demo.entities.concrates.concretes.Education;
import com.example.demo.entities.concrates.concretes.Experience;
import com.example.demo.entities.concrates.concretes.Image;
import com.example.demo.entities.concrates.concretes.LanguageLevel;
import com.example.demo.entities.concrates.concretes.Link;
import com.example.demo.entities.concrates.concretes.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWithAllRelatedEntitiesDto {

	private int id;

	private LocalDateTime creationDate;

	private Candidate candidate;

	private CoverLetter coverLetter;

	private Image image;

	private List<Education> educations;

	private List<Experience> experiences;

	private List<LanguageLevel> languageLevels;

	private List<Link> links;

	private List<Skill> skills;

}