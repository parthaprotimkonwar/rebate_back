package services.service.useractivities;

import application.exceptions.BaseException;
import models.abergin.AUser;
import models.bean.useractivities.UserTransactionBean;
import models.useractivities.UserTransaction;

/**
 * Created by pkonwar on 5/11/2016.
 */
public interface UserTransactionServiceI {

    /**
     * Create a transaction
     * @param user
     * @return
     * @throws BaseException
     */
    UserTransaction createUserTransaction(AUser user) throws BaseException;

    /**
     * Convert into usertransaction
     * @param userTransaction
     * @return
     * @throws BaseException
     */
    UserTransactionBean convertIntoUserTransactionBean(UserTransaction userTransaction) throws BaseException;
}
