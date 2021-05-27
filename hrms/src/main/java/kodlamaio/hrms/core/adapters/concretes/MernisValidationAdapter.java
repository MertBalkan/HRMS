package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.CandidateValidatonService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.services.MernisValidation;

@Service
public class MernisValidationAdapter implements CandidateValidatonService{

	@Override
	public boolean isCandidate(Candidate candidate) {
		return
		!candidate.getFirstName().isEmpty() 
		|| !candidate.getLastName().isEmpty() 
	    || !candidate.getNationalityId().isEmpty();
	}
}