package rest.bean.response;

import application.enums.STATUS;
import application.enums.USER_TYPE;

import java.io.Serializable;
import java.util.Date;

public class UserResponseBean implements Serializable {

    public UserResponseBean() {
    }

    public UserResponseBean(Long userId, USER_TYPE userType, String name, String email, String mobile, Date lastLogin, Date createdOn, String imageUrl, STATUS status) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.lastLogin = lastLogin;
        this.createdOn = createdOn;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public UserResponseBean(USER_TYPE userType, String name, String email, String mobile, Date lastLogin, Date createdOn, String imageUrl, STATUS status) {
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.lastLogin = lastLogin;
        this.createdOn = createdOn;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    private Long userId;

    private USER_TYPE userType;     //@Mandatory

    private String name;            //@Mandatory

    private String email;           //@Mandatory

    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
