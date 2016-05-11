package services.service;

import services.service.abergin.UserTokenServiceI;
import services.service.abergin.UsersServiceI;
import services.service.address.AddressServiceI;
import services.service.address.UserAddressServiceI;
import services.service.friends.UserFriendServiceI;
import services.service.payments.PaymentOptionServiceI;
import services.service.payments.UserPaymentOptionServiceI;
import services.service.serviceimpl.payments.UserPaymentOptionServiceImpl;
import services.service.useractivities.UserPointsServiceI;
import services.service.useractivities.UserTransactionServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public UsersServiceI usersService;

	@Inject
	public UserTokenServiceI userTokenService;

	@Inject
	public AddressServiceI addressService;

	@Inject
	public UserAddressServiceI userAddressService;

	@Inject
	public PersonServiceI personService;

	@Inject
	public UserFriendServiceI userFriendService;

	@Inject
	public PaymentOptionServiceI paymentOptionService;

	@Inject
	public UserPaymentOptionServiceI userPaymentOptionServiceI;

	@Inject
	public UserPointsServiceI userPointsService;

	@Inject
	public UserTransactionServiceI userTransactionService;
}
