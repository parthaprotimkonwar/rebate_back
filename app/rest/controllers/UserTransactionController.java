package rest.controllers;

import application.exceptions.BaseException;
import models.abergin.AUser;
import models.useractivities.UserTransaction;
import play.mvc.BodyParser;
import play.mvc.Result;
import rest.bean.request.UserTransactionRequestBean;
import rest.bean.response.ErrorResponse;
import rest.bean.response.LoginResponseBean;
import rest.bean.response.UserTransactionResponseBean;
import rest.factory.BaseController;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/13/2016.
 */
@Named
@Singleton
public class UserTransactionController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    @BodyParser.Of(BodyParser.Json.class)
    public Result userTransaction() {

        UserTransactionResponseBean response = null;
        try {
            UserTransactionRequestBean userBean = convertRequestBodyToObject(request().body(), UserTransactionRequestBean.class);
            AUser user = servicesFactory.userTokenService.findUserAttachedToToken(userBean.getToken());
            UserTransaction userTransaction = servicesFactory.userTransactionService.createUserTransaction(user);
            response = new UserTransactionResponseBean(userBean.getToken(), userTransaction.getUserTransactionId());

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(response);
    }

}
