package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@CrossOrigin
@RestController
@RequestMapping("/api/educations")
public class EducationController {
	
	private EducationService educationService;
	
	@Autowired
	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}

	@GetMapping
	DataResult<List<Education>> getAllDescSorted(){
		return this.educationService.getAllDescSorted();
	}
	@PostMapping("/add")
	Result add(@RequestBody Education education) {
		return this.educationService.add(education);
	}

	
}