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


	@Override
	public boolean equals(Object thatObject) {

		if(thatObject == null || thatObject.getClass() != getClass())
			return false;

		UserAddress thatUserAddress = (UserAddress)thatObject;
		return userIdAddressId.user.getUserId().equals(thatUserAddress.userIdAddressId.user.getUserId())
				&& userIdAddressId.address.getAddressId().equals(thatUserAddress.userIdAddressId.address.getAddressId());
	}

	@Override
	public int hashCode() {
		int userIdHashCode = 17;
		try {
			userIdHashCode = userIdAddressId.user.getUserId().hashCode();
		} catch (Exception ex){
		}
		int addressIdHashCode = 17;
		try {
			addressIdHashCode = userIdAddressId.address.getAddressId().hashCode();
		} catch (Exception ex) {

		}
		return userIdHashCode + addressIdHashCode;
	}
}
