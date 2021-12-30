package com.example.demo.business.concrates;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateService;
import com.example.demo.business.abstracts.ResumeService;
import com.example.demo.business.abstracts.UserActivationService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.controlManage.UserCheckService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.ErrorResult;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessDataResult;
import com.example.demo.core.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateDao;
import com.example.demo.entities.concrates.concretes.Candidate;
import com.example.demo.entities.concrates.concretes.Resume;
import com.example.demo.entities.concrates.concretes.UserActivation;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ResumeService resumeService;
	private UserService userService;
	private UserCheckService userCheckService;
	private UserActivationService userActivationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, ResumeService resumeService, UserService userService, UserCheckService userCheckService, UserActivationService userActivationService) {
		this.candidateDao = candidateDao;
		this.resumeService = resumeService;
		this.userService = userService;
		this.userCheckService = userCheckService;
		this.userActivationService = userActivationService;
	}

	@Override
	public Result add(Candidate candidate) {

		validateCandidate(candidate);
		
		candidateDao.save(candidate);
		resumeService.add(new Resume(candidate));		
		return userActivationService.add(new UserActivation(candidate));
	}

	@Override
	public Result update(Candidate candidate) {
		
		Candidate c = getById(candidate.getId()).getData();
		
		candidate.setEmail(candidate.getEmail() == null || candidate.getEmail() == ""
				? c.getEmail()
				: candidate.getEmail());
		candidate.setPassword(candidate.getPassword() == null || candidate.getPassword() == ""
				? c.getPassword()
				: candidate.getPassword());
		candidate.setFirstName(candidate.getFirstName() == null || candidate.getFirstName() == ""
				? c.getFirstName()
				: candidate.getFirstName());
		candidate.setLastName(candidate.getLastName() == null || candidate.getLastName() == ""
				? c.getLastName()
				: candidate.getLastName());		
		candidate.setIdentityNumber(candidate.getIdentityNumber() == null || candidate.getIdentityNumber() == ""
				? c.getIdentityNumber()
				: candidate.getIdentityNumber() );
		candidate.setDateOfBirth(candidate.getDateOfBirth() == null
				? c.getDateOfBirth()
				: candidate.getDateOfBirth());
		
		validateCandidate(candidate);

		candidateDao.save(candidate);
		return new SuccessResult("İş arayan güncellendi.");
	}

	@Override
	public Result delete(int id) {

		candidateDao.deleteById(id);;
		return new SuccessResult("İş arayan silindi.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(candidateDao.getById(id));
	}

	@Override
	public Result activate(String code) {

		UserActivation userActivation = userActivationService.getByCode(code).getData();

		if (userActivation == null) {
			return new ErrorResult("Geçersiz bir kod girdiniz.");
		}

		Candidate candidate = getById(userActivation.getUser().getId()).getData();

		userActivation.setActivated(true);
		userActivation.setIsActivatedDate(LocalDateTime.now());

		candidateDao.save(candidate);
		userActivationService.update(userActivation);
		return new SuccessResult("Üyelik işlemleri tamamlanmıştır.");
	}
	
	@Override
	public DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated) {
		return new SuccessDataResult<List<Candidate>>(candidateDao.getByUserActivation_IsActivated(isActivated));
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(candidateDao.getByIdentityNumber(identityNumber));
	}

	private boolean checkIfEmailExists(String email) {

		boolean result = false;

		if (userService.getByEmail(email).getData() == null) {
			result = true;
		}

		return result;
	}

	private boolean checkIfIdentityNumberExists(String identityNumber) {

		boolean result = false;

		if (getByIdentityNumber(identityNumber).getData() == null) {
			result = true;
		}

		return result;
	}

	private Result validateCandidate(Candidate candidate) {

		if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
		}

		if (!checkIfIdentityNumberExists(candidate.getIdentityNumber())) {
			return new ErrorResult("Girilen kimlik numarası başka bir hesaba aittir.");
		}

		if (!userCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth())) {
			return new ErrorResult("Lütfen bilgilerinizi doğru giriniz.");
		}

		return null;
	}

}
