package application;

/**
 * Created by pkonwar on 5/11/2016.
 */
public enum PAYMENT_MODE {

    CASH("CASH"),
    CHEQUE("CHEQUE");

    String paymentMode;

    private PAYMENT_MODE(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return paymentMode;
    }
}
