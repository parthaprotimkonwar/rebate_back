package services.service.abergin;

import models.abergin.AUser;
import models.abergin.UserToken;
import play.exceptions.BaseException;

public interface UserTokenServiceI {

	UserToken createToken(Long userId) throws BaseException;
	
	Boolean tokenExist(String tokenId) throws BaseException;
	
	UserToken createOrupdateToken(Long userId) throws BaseException;
	
	void removeToken(String tokenId) throws BaseException;
	
	UserToken tokenExistForUser(Long userId) throws BaseException;
	
	/**
	 * Find a user which has the token
	 * @return
	 * @throws BaseException
	 */
	AUser findUserAttachedToToken(String tokenId) throws BaseException;
	
}
