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
}
