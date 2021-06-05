package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperienceController {
	private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	
	@GetMapping("/getAllDescSorted")
	public DataResult<List<WorkExperience>> getAllDescSorted() {
		return this.workExperienceService.getAllDescSorted();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
}