package rest.bean.response;

import application.enums.STATUS;

import java.io.Serializable;

public class LoginResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public LoginResponseBean() {}

    public LoginResponseBean(Long userId, String token, STATUS status) {
        this.userId = userId;
        this.token = token;
        this.status = status;
    }

    private Long userId;
    private String token;
    private STATUS status;

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
}
