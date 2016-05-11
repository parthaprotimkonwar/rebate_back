package services.service.serviceimpl.useractivities;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.abergin.AUser;
import models.bean.useractivities.UserTransactionBean;
import models.useractivities.UserTransaction;
import org.springframework.transaction.annotation.Transactional;
import repository.useractivities.UserTransactionRepository;
import services.service.useractivities.UserTransactionServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Named
@Singleton
@Transactional
public class UserTransactionServiceImpl implements UserTransactionServiceI{

    @Inject
    UserTransactionRepository userTransactionRepository;

    @Override
    public UserTransaction createUserTransaction(AUser user) throws BaseException {
        try {
            UserTransaction userTransaction = new UserTransaction(user);
            return userTransactionRepository.save(userTransaction);
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }

    @Override
    public UserTransactionBean convertIntoUserTransactionBean(UserTransaction userTransaction) throws BaseException {
        try {
            return new UserTransactionBean(userTransaction.getUserTransactionId(), userTransaction.getUser().getUserId());
        } catch (Exception ex) {
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
        }
    }
}
