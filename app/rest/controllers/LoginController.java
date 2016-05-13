package rest.controllers;

import rest.factory.BaseController;
import play.Logger;
import play.Logger.ALogger;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class LoginController extends BaseController{
	
	public static final ALogger logger = Logger.of(LoginController.class);
	
	@Inject
	ServicesFactory serviceFactory;
	
	/**
	 * AUser can log in
	 * @return
	 */
	/*@BodyParser.Of(BodyParser.Json.class)
	public Result login() {
		logger.info("Inside login()");
		LoginResponseBean response = null;
		try {
			UserTransactionRequestBean userRequestDto = convertRequestBodyToObject(request().body(), UserTransactionRequestBean.class);
			UsersRequestDtoValidationEngine validator = new UsersRequestDtoValidationEngine();
			ValidationResponse status = validator.checkForMandatoryFields(userRequestDto, UserTransactionRequestBean.UsersRequestFields.userType);			//userType is mandatory for now
			if(!status.isValidated()) {
				throw new ValidationException(status.getErrorCode(), null, status.getErrorMessage());
			}
			UserType userType = UserType.value(userRequestDto.userType);
			UserToken userToken = null;
			
			switch (userType) {
				
				case FRUGAL:
					UserFrugal userFrugal = serviceFactory.usersFrugalService.login(userRequestDto);
					if(userFrugal != null) {
						 userToken = serviceFactory.userTokenService.createOrupdateToken(userFrugal.userId);
						 response = new LoginResponseBean(userFrugal.userId, userToken.tokenId, utilities.AppConstants.Status.SUCCESS.name());
					} else {
						throw new BaseException(INVALID_LOGIN.errorCode, INVALID_LOGIN.errorMessage);
					}
					break;
				
				case SOCIAL:
					UserSocial userSocial = null;
					userSocial = serviceFactory.usersSocialService.login(userRequestDto);

					if(userSocial == null) {	//AUser not registered
						AUser user = serviceFactory.usersService.createAUser(userRequestDto.userType);
						userSocial = serviceFactory.usersSocialService.createAUser(userRequestDto, user);
					}
					
					if(userSocial != null) {
						 userToken = serviceFactory.userTokenService.createOrupdateToken(userSocial.userId);
					}
					response = new LoginResponseBean(userSocial.userId, userToken.tokenId, utilities.AppConstants.Status.SUCCESS.name());
					break;
					
				case GUEST:
					UserGuest userGuest = null;
					userGuest = serviceFactory.usersGuestService.login(userRequestDto);
					
					if(userGuest == null) {
						AUser user = serviceFactory.usersService.createAUser(userRequestDto.userType);
						userGuest = serviceFactory.usersGuestService.createAUser(userRequestDto, user);
					}
					if(userGuest != null) {
						 userToken = serviceFactory.userTokenService.createOrupdateToken(userGuest.userId);
					}
					response = new LoginResponseBean(userGuest.userId, userToken.tokenId, utilities.AppConstants.Status.SUCCESS.name());
					break;
				
				default:
					throw new BaseException(NO_SUCH_USER_TYPE.errorCode, NO_SUCH_USER_TYPE.errorMessage);
			}
		} catch (ValidationException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getErrorMessages());
			logger.error("Exiting login()", ex.getCause());
			return validationErrorToJsonResponse(errorResponse);
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			logger.error("Exiting login()", ex.getCause());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			logger.error("Exiting login()", e.getCause());
			return errorObjectToJsonResponse(errorResponse);
		}
		logger.info("Exiting login()");
		return convertObjectToJsonResponse(response);
	}*/
	
	/**
	 * Sign up a user
	 * @return
	 */
	/*@BodyParser.Of(BodyParser.Json.class)
	public Result signup() {
		
		LoginResponseBean response;
		try { 
			UserTransactionRequestBean userRequestDto = convertRequestBodyToObject(request().body(), UserTransactionRequestBean.class);
			
			UsersRequestDtoValidationEngine validator = new UsersRequestDtoValidationEngine();
			ValidationResponse status = validator.checkForMandatoryFields(userRequestDto, UserTransactionRequestBean.UsersRequestFields.userType);			//userType is mandatory for now
			if(!status.isValidated()) {
				throw new ValidationException(status.getErrorCode(), null, status.getErrorMessage());
			}
			
			UserType userType = UserType.value(userRequestDto.userType);
			
			AUser user = serviceFactory.usersService.createAUser(userRequestDto.userType);
			
			response = null;
			UserToken userToken = null;
			
			switch (userType) {

				case FRUGAL:
					UserFrugal userFrugal = serviceFactory.usersFrugalService.findUserByEmail(userRequestDto.email);
					if(userFrugal == null) {		//email id not present in system
						userFrugal = serviceFactory.usersFrugalService.createAUser(userRequestDto, user);
						userToken = serviceFactory.userTokenService.createOrupdateToken(userFrugal.userId);
						response = new LoginResponseBean(userFrugal.userId, userToken.tokenId, utilities.AppConstants.Status.SUCCESS.name());
					} else {
						serviceFactory.usersService.deleteUser(user.userId); //deleting the already created user
						throw new BaseException(DUPLICATE_EMAIL_ID.errorCode, DUPLICATE_EMAIL_ID.errorMessage);
					}
					break;
					
				default:
					throw new BaseException(NO_SUCH_USER_TYPE.errorCode, NO_SUCH_USER_TYPE.errorMessage);
			}
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		return convertObjectToJsonResponse(response);
	}*/
}