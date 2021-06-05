package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<Resume>>  getResumeByCandidateId(int candidateId);
	DataResult<List<Resume>> getAll();
	Result add(Resume resume);
}