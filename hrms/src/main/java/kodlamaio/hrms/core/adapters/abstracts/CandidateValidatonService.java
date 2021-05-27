package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateValidatonService {
	boolean isCandidate(Candidate candidate);
}