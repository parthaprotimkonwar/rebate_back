package rest.bean.request;

import java.io.Serializable;

public class UserTransactionRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String token;

	public UserTransactionRequestBean() {}

	public UserTransactionRequestBean(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}