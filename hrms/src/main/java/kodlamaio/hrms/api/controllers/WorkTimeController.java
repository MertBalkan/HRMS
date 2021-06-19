package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.WorkTime;

@CrossOrigin
@RestController
@RequestMapping("/api/workTimes")
public class WorkTimeController {
	
	private WorkTimeService workTimeService;
	
	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<WorkTime>> getAll(){
		return this.workTimeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody WorkTime workTime) {
		return this.workTimeService.add(workTime);
	}
	
	
}