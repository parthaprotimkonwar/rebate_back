package services.service.address;

import java.util.List;

import controllers.requestdto.AddressRequestDto;
import controllers.responsedto.AddressDto;
import models.abergin.AUser;
import models.address.UserAddress;
import play.exceptions.BaseException;

public interface UserAddressServiceI {
	
	/**
	 * Create a new UserAddress
	 * @return
	 * @throws BaseException
	 */
	UserAddress createUserAddress(AUser user, AddressRequestDto address) throws BaseException;

	/**
	 * Find UserAddress for a AUser
	 * @return
	 * @throws BaseException
	 */
	List<AddressDto> findUserAddress(AUser user) throws BaseException;
}
