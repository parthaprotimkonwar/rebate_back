package models.address;

import models.Constants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="USER_ADDRESS", schema= Constants.SCHEMA_NAME_REABTE_ADDRESS)
public class UserAddress implements Serializable{

	@EmbeddedId
	public UserIdAddressId userIdAddressId;

	public UserAddress() {}
	
	public UserAddress(UserIdAddressId userIdAddressId) {
		this.userIdAddressId = userIdAddressId;
	}
}
