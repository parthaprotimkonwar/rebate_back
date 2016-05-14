package services.service.useractivities;

import application.exceptions.BaseException;
import models.abergin.AUser;
import models.bean.useractivities.UserPointsBean;
import models.useractivities.UserPoints;

/**
 * Created by pkonwar on 5/11/2016.
 */
public interface UserPointsServiceI {

    UserPoints findPointsAttachedToAUser(AUser user) throws BaseException;

    UserPointsBean convertIntoUserPointsBean(UserPoints userPoints) throws BaseException;

}
