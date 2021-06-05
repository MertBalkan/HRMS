package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}
	
	@Override
	public DataResult<List<Resume>> getResumeByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByCandidate_Id(candidateId), "Candidate Resume Listed!");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(), "CV's Listed");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Resume Added");
	}
	
}
