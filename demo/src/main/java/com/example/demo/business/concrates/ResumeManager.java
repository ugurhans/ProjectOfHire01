package com.example.demo.business.concrates;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CoverLetterService;
import com.example.demo.business.abstracts.EducationService;
import com.example.demo.business.abstracts.ExperienceService;
import com.example.demo.business.abstracts.ImageService;
import com.example.demo.business.abstracts.ResumeService;
import com.example.demo.core.results.DataResult;

import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.ResumeDao;
import com.example.demo.entities.concrates.Dtos.ResumeWithAllRelatedEntitiesDto;
import com.example.demo.entities.concrates.concretes.Resume;
@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CoverLetterService coverLetterService;
	private ImageService imageService;
	private EducationService educationService;
	private ExperienceService experienceService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CoverLetterService coverLetterService, ImageService imageService, EducationService educationService, ExperienceService experienceService) {
		this.resumeDao = resumeDao;
		this.coverLetterService = coverLetterService;
		this.imageService = imageService;
		this.educationService = educationService;
		this.experienceService = experienceService;
	}

	@Override
	public Result add(Resume resume) {

		resume.setCreationDate(LocalDateTime.now());

		resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş eklendi.");
	}

	@Override
	public Result update(Resume resume) {
		
		resume = getById(resume.getId()).getData();		
		resume.setCreationDate(LocalDateTime.now());

		resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş güncellendi.");
	}

	@Override
	public Result delete(int id) {

		resumeDao.deleteById(id);
		return new SuccessResult("Özgeçmiş silindi.");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "creationDate");
		
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(sort));
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(resumeDao.getById(id));
	}

	@Override
	public Result addCoverLetterToResume(int resumeId, int coverLetterId) {

		Resume resume = getById(resumeId).getData();
		resume.setCoverLetter(coverLetterService.getById(coverLetterId).getData());

		update(resume);
		return new SuccessResult("Ön yazı özgeçmişe eklendi.");
	}
	
	@Override
	public Result deleteCoverLetterFromResume(int resumeId) {
		
		Resume resume = getById(resumeId).getData();
		resume.setCoverLetter(null);

		update(resume);
		return new SuccessResult("Ön yazı özgeçmişten kaldırıldı.");
	}
	
	@Override
	public DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByActivatedCandidate() {
		
		List<ResumeWithAllRelatedEntitiesDto> resumes = new ArrayList<ResumeWithAllRelatedEntitiesDto>();
		
		for (Resume resume : getAll().getData()) {
			if (resume.getCandidate().getUserActivation().isActivated() == true ) {
				resumes.add(getResumeDetailsByCandidateId(resume.getCandidate().getId()).getData());
			}			
		};
		
		return new SuccessDataResult<List<ResumeWithAllRelatedEntitiesDto>>(resumes);
	}

	@Override
	public DataResult<Resume> getByCandidateId(int candidateId) {
		return new SuccessDataResult<Resume>(resumeDao.getByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId) {

		Resume resume = getByCandidateId(candidateId).getData();

		ResumeWithAllRelatedEntitiesDto resumeWithAllRelatedEntitiesDto = new ResumeWithAllRelatedEntitiesDto(
				resume.getId(),
				resume.getCreationDate(),
				resume.getCandidate(),
				resume.getCoverLetter(),
				imageService.getByUserId(candidateId).getData(),
				educationService.getAllByResumeIdSortedByGraduationDate(resume.getId()).getData(),
				experienceService.getAllByResumeIdSortedByTerminationDate(resume.getId()).getData(),
				resume.getLanguageLevels(),
				resume.getLinks(),
				resume.getSkills()
				);

		return new SuccessDataResult<ResumeWithAllRelatedEntitiesDto>(resumeWithAllRelatedEntitiesDto);
	}

}