package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<Resume>>  getResumeByCandidateId(int candidateId);
	DataResult<List<Resume>> getAll();
	DataResult<Resume> imageUpload(int resumeId, MultipartFile multipartFile) throws IOException;
	Result add(Resume resume);
}