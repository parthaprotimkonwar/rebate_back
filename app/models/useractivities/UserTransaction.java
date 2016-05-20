package models.useractivities;

import models.abergin.AUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Entity
@Table
public class UserTransaction implements Serializable{

    public UserTransaction(){}

    public UserTransaction(AUser user){
        this.user = user;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_TRANSACTION_ID")
    private Long userTransactionId;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private AUser user;

    public Long getUserTransactionId() {
        return userTransactionId;
    }

    public void setUserTransactionId(Long userTransactionId) {
        this.userTransactionId = userTransactionId;
    }

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }
}
