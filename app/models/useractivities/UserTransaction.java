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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_TRANSACTION_ID")
    private Long userTransactionId;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    public AUser user;

    @Column(name = "TRANSACTION_ID", length = 50)
    private String transactionId;
}
