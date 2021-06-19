package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@CrossOrigin
@RestController
@RequestMapping("/api/coverLetters")
public class CoverLetterController {
	
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<CoverLetter>> getAll(){
		return coverLetterService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CoverLetter coverLetter) {
		return coverLetterService.add(coverLetter);
	}
	
}