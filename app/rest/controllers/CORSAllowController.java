package rest.controllers;

import play.mvc.Result;
import play.mvc.Results;
import rest.factory.BaseController;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/13/2016.
 */
@Named
@Singleton
public class CORSAllowController extends BaseController{

    public Result enablecors() {
        response().setHeader("Access-Control-Allow-Origin", request().getHeader("Origin"));
        response().setHeader("Access-Control-Allow-Methods", "HEAD,GET,PUT,DELETE,OPTIONS");
        response().setHeader("Access-Control-Max-Age", "10000");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referrer, User-Agent");
        return ok();
    }
}
