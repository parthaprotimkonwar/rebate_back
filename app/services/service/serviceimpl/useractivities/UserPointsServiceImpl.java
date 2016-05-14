package services.service.serviceimpl.useractivities;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.useractivities.UserPointsBean;
import models.useractivities.UserPoints;
import models.useractivities.UserTransaction;
import repository.useractivities.UserPointsRepository;
import services.service.useractivities.UserPointsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Named
@Singleton
public class UserPointsServiceImpl implements UserPointsServiceI {

    @Inject
    UserPointsRepository userPointsRepository;

    @Override
    public UserPoints findPointsAttachedToAUser(AUser user) throws BaseException {
        try {
            return userPointsRepository.findByUser(user);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public UserPointsBean convertIntoUserPointsBean(UserPoints userPoints) throws BaseException {
        return new UserPointsBean(userPoints.getUser().getUserId(), userPoints.getPoints());
    }


}
