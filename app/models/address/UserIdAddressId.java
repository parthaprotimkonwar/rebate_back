package models.address;

import models.abergin.AUser;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserIdAddressId implements Serializable{

	private static final long serialVersionUID = 1L;

	public UserIdAddressId(AUser user, Address address) {
		this.user = user;
		this.address = address;
	}
	
	public UserIdAddressId() {}
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	public AUser user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADDRESS_ID")
	public Address address;
	
}
