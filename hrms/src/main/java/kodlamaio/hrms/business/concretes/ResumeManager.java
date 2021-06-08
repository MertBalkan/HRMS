package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.services.cloudinary.abstracts.ImageCloudinaryService;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private ImageCloudinaryService imageCloudinaryService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, ImageCloudinaryService imageCloudinaryService) {
		this.resumeDao = resumeDao;
		this.imageCloudinaryService = imageCloudinaryService;
	}
	
	@Override
	public DataResult<List<Resume>> getResumeByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByCandidate_Id(candidateId), "Candidate Resume Listed!");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(), "CV's Listed");
	}
	
	@Override
	public DataResult<Resume> imageUpload(int resumeId, MultipartFile multipartFile)
			throws IOException {
		Resume resume = this.resumeDao.findById(resumeId).get();
		var result = this.imageCloudinaryService.imageUpload(multipartFile);
		resume.setPhotoLink(result.getData().get("url").toString());
		this.resumeDao.save(resume);
		return new SuccessDataResult<>("Photo has been saved successfuly");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Resume Added");
	}
	
}
