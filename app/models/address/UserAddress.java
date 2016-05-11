package models.address;

import static utilities.Constants.SCHEMA_NAME_AUTHORIZATION;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="USER_ADDRESS", schema=SCHEMA_NAME_AUTHORIZATION)
public class UserAddress implements Serializable{

	@EmbeddedId
	public UserIdAddressId userIdAddressId;

	public UserAddress() {}
	
	public UserAddress(UserIdAddressId userIdAddressId) {
		this.userIdAddressId = userIdAddressId;
	}
}
