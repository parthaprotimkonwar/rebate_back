package services.service.serviceimpl.abergin;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import models.abergin.AUser;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.abergin.AUsersRepository;
import services.service.abergin.UsersServiceI;

@Named
@Singleton
public class UsersServiceImpl implements UsersServiceI{

	@Inject
	AUsersRepository AUsersRepository;
	
	@Override
	public AUser createUser(String userType) throws BaseException{
		try {
			AUser user = new AUser(userType);
			AUsersRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserById(@NotNull Long userId) throws BaseException{
		try {
			return AUsersRepository.findOne(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AUser> users() throws BaseException{
		try {
			return AUsersRepository.findAll();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public void deleteUser(Long userId) throws BaseException {
		try {
			AUsersRepository.delete(userId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_REMOVAL_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

}
