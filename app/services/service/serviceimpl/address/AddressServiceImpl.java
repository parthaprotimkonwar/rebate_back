package services.service.serviceimpl.address;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rest.bean.request.AddressRequestDto;
import models.address.Address;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import repository.address.AddressRepository;
import services.service.address.AddressServiceI;

@Named
@Singleton
public class AddressServiceImpl implements AddressServiceI{

	@Inject
	AddressRepository addressRepository;

	@Override
	public Address createAddress(AddressRequestDto address) throws BaseException {
		try {
			Address completeAddress = new Address(address.addressHeading, address.pincode, address.address, address.landmark, address.phoneNo, address.city, address.state, address.country);
			return addressRepository.save(completeAddress);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	
	@Override
	public Address retrieveAddress(Long addressId) throws BaseException {
		try {
			return addressRepository.findOne(addressId);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
	
}
