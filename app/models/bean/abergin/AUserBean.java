package models.bean.abergin;

import application.enums.STATUS;
import application.enums.USER_TYPE;

import java.io.Serializable;
import java.util.Date;

public class AUserBean implements Serializable {

    public AUserBean(Long userId, USER_TYPE userType, String name, String email, String password, Date lastLogin, Date createdOn, String imageUrl, STATUS status) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;
        this.createdOn = createdOn;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    private Long userId;

    private USER_TYPE userType;

    private String name;

    private String email;

    private String password;

    private Date lastLogin;

    private Date createdOn;

    private String imageUrl;

    private STATUS status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
