package repository.payments;

import models.payments.UserIdPaymentOptionId;
import models.payments.UserPaymentOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Repository
public interface UserPaymentOptionsRepository extends JpaRepository<UserPaymentOption, UserIdPaymentOptionId>{
}
