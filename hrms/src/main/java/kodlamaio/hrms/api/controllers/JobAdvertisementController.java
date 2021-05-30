package kodlamaio.hrms.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByDeadline")
	public DataResult<List<JobAdvertisement>> getByDeadline(Date deadline){
		return this.jobAdvertisementService.getByOrderDeadline(deadline);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/getActivity")
	public Result getActivity(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.getActivity(jobAdvertisementId);
	}
}