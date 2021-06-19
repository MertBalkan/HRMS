package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{
	
	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao){
		this.workTypeDao = workTypeDao;
	}
	
	@Override
	public DataResult<List<WorkType>> getAll(){
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(), "Work Types Listed Successfuly");
	}

	@Override
	public Result add(WorkType workType) {
		return new SuccessResult("Work Type Added");
	}
}