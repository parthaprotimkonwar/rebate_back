package repository.payments;

import models.payments.PaymentOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Repository
public interface PaymentOptionRepository extends JpaRepository<PaymentOption,Long>{
}
