package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	DataResult<List<CoverLetter>> getAll();
	Result add(CoverLetter coverLetter);
}