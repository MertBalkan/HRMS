package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
	DataResult<List<WorkTime>> getAll();
	Result add(WorkTime workTime);
}