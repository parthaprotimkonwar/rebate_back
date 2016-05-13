package models.payments;

import models.abergin.AUser;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Embeddable
public class UserIdPaymentOptionId implements Serializable{


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private AUser user;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="PAYMENT_OPTIONS_ID")
    private PaymentOption paymentOption;

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }
}
