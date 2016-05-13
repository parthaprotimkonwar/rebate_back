package services.service.serviceimpl.address;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.abergin.AUser;
import org.springframework.transaction.annotation.Transactional;

import rest.bean.request.AddressRequestDto;
import rest.bean.response.AddressDto;
import models.address.Address;
import models.address.UserAddress;
import models.address.UserIdAddressId;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import repository.address.AddressRepository;
import repository.address.UserAddressRepository;
import repository.abergin.AUsersRepository;
import services.service.address.UserAddressServiceI;

@Named
@Singleton
@Transactional
public class UserAddressServiceImpl implements UserAddressServiceI{

	@Inject
	UserAddressRepository userAddressRepository;
	
	@Inject
	AUsersRepository AUsersRepository;
	
	@Inject
	AddressRepository addressRepository;
	
	@Override
	public UserAddress createUserAddress(AUser user, AddressRequestDto address) throws BaseException {
		try {
			Address completeAddress = new Address(address.addressHeading, address.pincode, address.address, address.landmark, address.phoneNo, address.city, address.state, address.country);
			addressRepository.save(completeAddress);
			
			UserIdAddressId userIdAddressId = new UserIdAddressId(user, completeAddress);
			UserAddress userAddress = new UserAddress(userIdAddressId);
			return userAddressRepository.save(userAddress);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public List<AddressDto> findUserAddress(AUser user) throws BaseException {
		try {
			List<UserAddress> userAddresses = userAddressRepository.findAllByUserIdAddressIdUserUserId(user.getUserId());
			List<AddressDto> addressDto = new ArrayList<>();
			for(UserAddress userAddress : userAddresses) {
				Address a = userAddress.userIdAddressId.address;
				AddressDto address = new AddressDto(a.getAddressId(), a.getAddressHeading(), a.getPincode(), a.getAddress(), a.getLandmark(), a.getPhoneNo(), a.getCity(), a.getState(), a.getCountry());
				addressDto.add(address);
			}
			return addressDto;
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}
