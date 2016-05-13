package services.service.serviceimpl.abergin;

import application.enums.STATUS;
import application.enums.USER_TYPE;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;
import repository.abergin.AUsersRepository;
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
			AUserBean defaultAUserBean = new AUserBean(USER_TYPE.REBATE, null, null, null, "DEFAULT_PASSWORD", new Date(), new Date(), "DEFAULT_IMAGE_URL", STATUS.SUCCESS);
			userBean = userBean.superImposeUser(defaultAUserBean);
			AUser user = new AUser(userBean.getUserType(), userBean.getName(), userBean.getEmail(), userBean.getMobile(), userBean.getPassword(), userBean.getImageUrl(), userBean.getLastLogin(), userBean.getCreatedOn(), userBean.getStatus());
			AUsersRepository.save(user);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser login(AUserBean userBean) throws BaseException {
		try {
			AUser user = null;
			if(userBean.getUserType() == USER_TYPE.REBATE) {
				user = findUserByEmailAndPassword(userBean.getEmail(), userBean.getPassword());		//Login for REABTE users
			} else {
				user = findUserByEmail(userBean.getEmail(), userBean.getUserType());				//Login for Social Users
				if(user == null) {
					user = createAUser(userBean);													//If Social User not present Signup them
				}
			}
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmailAndPassword(String email, String password) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndPasswordAndUserType(email, password, USER_TYPE.REBATE);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public AUser findUserByEmail(String email, USER_TYPE userType) throws BaseException {
		try {
			AUser user = AUsersRepository.findByEmailAndUserType(email, userType);
			return user;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
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

	@Override
	public AUserBean convertToUserBean(AUser aUser) throws BaseException {
		return new AUserBean(aUser.getUserId(), aUser.getUserType(), aUser.getName(), aUser.getEmail(), aUser.getMobile(), aUser.getPassword(), aUser.getLastLogin(), aUser.getCreatedOn(), aUser.getImageUrl(), aUser.getStatus());
	}

}
