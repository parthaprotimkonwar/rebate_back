package rest.controllers;

import play.mvc.BodyParser;
import play.mvc.Result;
import services.service.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Named
@Singleton
public class UserLoginController {

    @Inject
    ServicesFactory servicesFactory;

    @BodyParser.Of(BodyParser.Json.class)
    public Result signUp() {
        return null;
    }
}
