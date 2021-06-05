package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

	private TechnologyService technologyService;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping
	DataResult<List<Technology>> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping
	Result add(@RequestBody Technology technology) {
		return technologyService.add(technology);
	}
	
}