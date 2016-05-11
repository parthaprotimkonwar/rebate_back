package services.service.abergin;

import java.util.List;

import models.abergin.AUser;
import play.exceptions.BaseException;

public interface UsersServiceI {

	AUser createUser(String userType) throws BaseException;
	
	AUser findUserById(Long userId) throws BaseException;
	
	List<AUser> users() throws BaseException;
	
	void deleteUser(Long userId) throws BaseException;
}
