package kodlamaio.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByOrderDeadline(Date deadline);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	Result getActivity(int jobAdvertisementId);

}