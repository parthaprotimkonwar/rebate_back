package models.payments;

import application.enums.PAYMENT_MODE;
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
    private Set<UserPaymentOption> userPaymentOptionSet;

    public Long getPaymentOptionsId() {
        return paymentOptionsId;
    }

    public void setPaymentOptionsId(Long paymentOptionsId) {
        this.paymentOptionsId = paymentOptionsId;
    }

    public PAYMENT_MODE getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PAYMENT_MODE paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Set<UserPaymentOption> getUserPaymentOptionSet() {
        return userPaymentOptionSet;
    }

    public void setUserPaymentOptionSet(Set<UserPaymentOption> userPaymentOptionSet) {
        this.userPaymentOptionSet = userPaymentOptionSet;
    }
}
