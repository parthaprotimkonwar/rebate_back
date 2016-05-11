package services.service.serviceimpl.abergin;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import repository.abergin.AUsersRepository;
import repository.address.AddressRepository;
import services.service.abergin.AUsersServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Named
@Singleton
public class AUsersServiceImpl implements AUsersServiceI {

	@Inject
	AUsersRepository AUsersRepository;
	
	@Override
	public AUser createAUser(AUserBean userBean) throws BaseException{
		try {
			AUser user = new AUser(userBean.getUserType(), userBean.getName(), userBean.getEmail(), userBean.getPassword(), userBean.getImageUrl(), new Date(), new Date(), userBean.getStatus());
			AUsersRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmailAndPassword(String email, String password) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndPassword(email, password);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmail(String email) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmail(email);
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
