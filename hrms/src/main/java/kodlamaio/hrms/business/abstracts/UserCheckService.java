package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface UserCheckService {
	void checkIsEmailValid(User user);
}