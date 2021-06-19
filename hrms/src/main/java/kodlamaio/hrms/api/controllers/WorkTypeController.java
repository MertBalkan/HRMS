package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.WorkType;

@CrossOrigin
@RestController
@RequestMapping("/api/workTypes")
public class WorkTypeController {
	
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody WorkType workType) {
		return this.workTypeService.add(workType);
	}
}