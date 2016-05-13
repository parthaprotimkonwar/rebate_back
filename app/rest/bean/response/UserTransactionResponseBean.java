package rest.bean.response;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/13/2016.
 */
public class UserTransactionResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private Long transactionId;

    public UserTransactionResponseBean(String token, Long transactionId) {
        this.token = token;
        this.transactionId = transactionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}