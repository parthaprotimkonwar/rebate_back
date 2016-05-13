package models.payments;

import models.Constants;
import models.abergin.AUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Entity
@Table(name = "USER_PAYMENT_OPTIONS", schema = Constants.SCHEMA_NAME_REABTE_PAYMENTS)
public class UserPaymentOption implements Serializable{

    @EmbeddedId
    private UserIdPaymentOptionId userIdPaymentOptionId;

    @Override
    public boolean equals(Object thatObject) {

        if(thatObject == null || thatObject.getClass() != getClass())
            return false;

        UserPaymentOption thatUserPaymentOption = (UserPaymentOption)thatObject;
        return userIdPaymentOptionId.getUser().getUserId().equals(thatUserPaymentOption.userIdPaymentOptionId.getUser().getUserId()) &&
                userIdPaymentOptionId.getPaymentOption().getPaymentOptionsId().equals(thatUserPaymentOption.userIdPaymentOptionId.getPaymentOption().getPaymentOptionsId());
    }

    @Override
    public int hashCode() {
        int userIdHashCode = userIdPaymentOptionId.getUser().getUserId().hashCode();
        int paymentOptionIdHashCode = userIdPaymentOptionId.getPaymentOption().getPaymentOptionsId().hashCode();
        return userIdHashCode + paymentOptionIdHashCode;
    }
}
