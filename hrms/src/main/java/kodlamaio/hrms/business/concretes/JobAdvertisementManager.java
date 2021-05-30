package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Job Advertisements Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByOrderDeadline(Date deadline) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByDeadline(deadline), "Job Advertisements Getted By Deadline");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Added Successfuly");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName), "Active Companies Listed");
	}

	@Override
	public Result getActivity(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		jobAdvertisement.setActive(!jobAdvertisement.isActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		if(jobAdvertisement.isActive()) {
			return new SuccessResult("Job Advertisement is now Active!");
		}
		return new SuccessResult("Job Advertisement is now Passive!");
		
	}
}