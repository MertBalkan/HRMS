package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService{
	
	private PersonnelDao personnelDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
		this.personnelDao = personnelDao;
	}
	
	@Override
	public DataResult<List<Personnel>> getAll() {
		return new SuccessDataResult<List<Personnel>>(personnelDao.findAll(), "Personnels Listed");
	}

	@Override
	public Result add(Personnel personnel) {
		this.personnelDao.save(personnel);
		return new SuccessResult("Personnel Added");
	}
}