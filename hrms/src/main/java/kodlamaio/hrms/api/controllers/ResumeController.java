package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
	
	private ResumeService resumeService;
	
	@Autowired
	public ResumeController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	
	@GetMapping("/getByCandidateCandidateId")
	public DataResult<List<Resume>> getResumeByCandidateId(int candidateId) {
		return this.resumeService.getResumeByCandidateId(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
}