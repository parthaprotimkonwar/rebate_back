package services.service.serviceimpl.payments;

import org.springframework.transaction.annotation.Transactional;
import services.service.payments.PaymentOptionServiceI;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Named
@Singleton
@Transactional
public class PaymentOptionServiceImpl implements PaymentOptionServiceI{
}
