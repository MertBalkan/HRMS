package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}
	
	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.findAll(), "Cover Letter's Listed");
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover Letter Added");
	}
}