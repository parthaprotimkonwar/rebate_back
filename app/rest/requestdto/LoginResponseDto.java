package rest.requestdto;

import java.io.Serializable;

import rest.responsedto.ErrorResponse;

public class LoginResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LoginResponseDto(String token) {
		this.token = token;
	}
	
	public LoginResponseDto(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	public String token;
	public ErrorResponse errorResponse;
	
}
