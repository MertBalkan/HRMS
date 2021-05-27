package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {
	
	private PersonnelService personnelService;
	
	@Autowired
	public PersonnelController(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Personnel>> getAll(){
		return this.personnelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Personnel personnel) {
		return this.personnelService.add(personnel);
	}
}