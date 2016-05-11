package models.payments;

import application.PAYMENT_MODE;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Entity
@Table(name = "PAYMENT_OPTIONS", schema = Constants.SCHEMA_NAME_REABTE_PAYMENTS)
public class PaymentOption implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_OPTIONS_ID")
    private Long paymentOptionsId;

    @Column(name = "PAYMENT_MODE")
    @Enumerated(value = EnumType.ORDINAL)
    private PAYMENT_MODE paymentMode;

    @Column(name = "BANK_NAME", length = 30)
    private String bankName;

    @Column(name = "ACCOUNT_HOLDER_NAME", length = 30)
    private String accountHolderName;

    @Column(name = "BRANCH_NAME", length = 30)
    private String branchName;

    @Column(name = "IFSC_CODE", length = 30)
    private String IFSCCode;

    @Column(name = "BANK_ACCOUNT_NO", length = 30)
    private String bankAccountNumber;

    @OneToMany(mappedBy="userIdPaymentOptionId.paymentOption")
    public Set<UserPaymentOption> userPaymentOptionSet;

}
