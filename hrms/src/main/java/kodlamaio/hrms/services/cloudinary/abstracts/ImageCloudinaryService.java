package kodlamaio.hrms.services.cloudinary.abstracts;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;


public interface ImageCloudinaryService {
	DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException;

}