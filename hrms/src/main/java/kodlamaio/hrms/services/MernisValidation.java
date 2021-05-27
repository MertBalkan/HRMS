package kodlamaio.hrms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.CandidateValidatonService;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisValidation {
	
	private CandidateValidatonService candidateValidationService;
	
	@Autowired
	public MernisValidation(CandidateValidatonService candidateValidationService) {
		this.candidateValidationService = candidateValidationService;
	}
	
	public Result isCandidate(Candidate candidate) {
		try {
			if(candidateValidationService.isCandidate(candidate)) {
				return new SuccessResult("Valid for mernis!");
			}
		}catch(Exception e) {	
			return new ErrorResult("Not valid for mernis!");
		}
		return null;
	}
}