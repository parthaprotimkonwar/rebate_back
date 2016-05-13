package services.service.address;

import rest.bean.request.AddressRequestDto;
import models.address.Address;
import application.exceptions.BaseException;

public interface AddressServiceI {

	/**
	 * Creates a new Address
	 * @return
	 * @throws BaseException
	 */
	Address createAddress(AddressRequestDto address) throws BaseException;
	
	
	/**
	 * Returns Address based on addressId
	 * @param addressId
	 * @return
	 * @throws BaseException
	 */
	Address retrieveAddress(Long addressId) throws BaseException;
}
