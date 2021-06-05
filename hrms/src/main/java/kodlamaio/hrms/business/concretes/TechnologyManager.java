package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		this.technologyDao = technologyDao;
	}
	
	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(technologyDao.findAll(), "Technologies Listed");
	}

	@Override
	public Result add(Technology technology) {
		this.technologyDao.save(technology);
		return new SuccessResult("Technology added");
	}

}