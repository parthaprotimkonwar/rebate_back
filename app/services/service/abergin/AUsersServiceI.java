package services.service.abergin;

import application.exceptions.BaseException;
import com.fasterxml.jackson.databind.deser.Deserializers;
import models.abergin.AUser;
import models.bean.abergin.AUserBean;

import java.util.List;

public interface AUsersServiceI {

	/**
	 * Create a new User
	 * @param userBean
	 * @return
	 * @throws BaseException
	 */
	AUser createAUser(AUserBean userBean) throws BaseException;

	/**
	 * Find a user by emailId and Password
	 * @param email
	 * @param password
	 * @return
	 * @throws BaseException
	 */
	AUser findUserByEmailAndPassword(String email, String password) throws BaseException;

	/**
	 * Find a User by emailId.
	 * @param email
	 * @return
	 * @throws BaseException
	 */
	AUser findUserByEmail(String email) throws BaseException;

	/**
	 * Find a new User
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	AUser findUserById(Long userId) throws BaseException;

	/**
	 * Find all users
	 * @return
	 * @throws BaseException
	 */
	List<AUser> users() throws BaseException;

	/**
	 * Delete a user.
	 * @param userId
	 * @throws BaseException
	 */
	void deleteUser(Long userId) throws BaseException;
}
