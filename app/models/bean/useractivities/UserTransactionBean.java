package models.bean.useractivities;

import models.abergin.AUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
public class UserTransactionBean implements Serializable{

    private Long userTransactionId;

    private Long user;

    public UserTransactionBean(Long userTransactionId, Long user) {
        this.userTransactionId = userTransactionId;
        this.user = user;
    }

    public Long getUserTransactionId() {
        return userTransactionId;
    }

    public void setUserTransactionId(Long userTransactionId) {
        this.userTransactionId = userTransactionId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
