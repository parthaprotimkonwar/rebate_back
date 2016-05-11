package services.service.serviceimpl.thirdparty;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import repository.thirdparty.UserCommunicationRepository;
import services.service.thirdparty.UserCommunicationServiceI;

@Named
@Singleton
public class UserCommunicationServiceImpl implements UserCommunicationServiceI{

	@Inject
	UserCommunicationRepository userCommunicationRepository;
}
