package rest.controllers;

import application.enums.STATUS;
import application.exceptions.BaseException;
import models.abergin.AUser;
import models.address.UserAddress;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.factory.BaseController;
import rest.requestdto.AddressRequestDto;
import rest.responsedto.AddressDto;
import rest.responsedto.AddressResponseDto;
import rest.responsedto.ErrorResponse;
import rest.responsedto.ListsAddressResponseDto;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public class ActivitiesController extends BaseController{

	@Inject
	ServicesFactory servicesFactory;
	
	/**
	 * Creates a new Address and Attaches it to a user
	 * @return
	 */
	@BodyParser.Of(BodyParser.Json.class)
	public Result createNewAddress() {
		
		AddressResponseDto response = null;
		try {
			AddressRequestDto addressRequest = convertRequestBodyToObject(request().body(), AddressRequestDto.class);
			AUser user = servicesFactory.userTokenService.findUserAttachedToToken(addressRequest.token);
			UserAddress userAddress = servicesFactory.userAddressService.createUserAddress(user, addressRequest);
			response = new AddressResponseDto(addressRequest.token, userAddress.userIdAddressId.address.addressId, STATUS.SUCCESS.name());
			
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(response);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result listsAddress() {
		
		ListsAddressResponseDto response = null;
		try {
			AddressRequestDto addressRequest = convertRequestBodyToObject(request().body(), AddressRequestDto.class);
			AUser user = servicesFactory.userTokenService.findUserAttachedToToken(addressRequest.token);
			List<AddressDto> addresses = servicesFactory.userAddressService.findUserAddress(user);
			response = new ListsAddressResponseDto(addressRequest.token, addresses, STATUS.SUCCESS.name());
			
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(response);
	}
	
	/*@BodyParser.Of(BodyParser.Json.class)
	public Result getUser()
	{
		UserDetailsBean userDetails = new UserDetailsBean();
		try
		{
			Map<String, Integer> map = convertRequestBodyToObject(request().body(), Map.class);
			Long userId = map.get("userId").longValue();
			UserGuest user = servicesFactory.usersGuestService.findUserById(userId);
			
			if(user == null)
			{
				throw new BusinessException(1001, "AUser is invalid");
			}
			
			userDetails.setUserId(userId);
			userDetails.setEmail(user.emailId);
			userDetails.setPhoneno(user.phoneNo);
		}
		catch (BaseException ex)
		{
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		}
		catch (BusinessException e)
		{
			ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode() + "", e.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(userDetails);
	}*/
}
