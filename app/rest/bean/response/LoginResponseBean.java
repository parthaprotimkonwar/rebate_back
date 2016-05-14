package rest.bean.response;

import application.enums.STATUS;
import models.bean.abergin.AUserBean;

import java.io.Serializable;

public class LoginResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public LoginResponseBean() {}

    public LoginResponseBean(Long userId, String token, STATUS status, AUserBean userDetails) {
        this.userId = userId;
        this.token = token;
        this.status = status;
        this.userDetails = userDetails;
    }

    private Long userId;
    private String token;
    private STATUS status;
    private AUserBean userDetails;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public AUserBean getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(AUserBean userDetails) {
        this.userDetails = userDetails;
    }
}
