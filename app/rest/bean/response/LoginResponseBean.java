package rest.bean.response;

import application.enums.STATUS;

import java.io.Serializable;

public class LoginResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public LoginResponseBean() {}

    public LoginResponseBean(Long userId, String token, STATUS status, UserResponseBean userDetails) {
        this.userId = userId;
        this.token = token;
        this.status = status;
        this.userDetails = userDetails;
    }

    private Long userId;
    private String token;
    private STATUS status;
    private UserResponseBean userDetails;


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

    public UserResponseBean getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserResponseBean userDetails) {
        this.userDetails = userDetails;
    }
}
