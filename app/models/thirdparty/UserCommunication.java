package models.thirdparty;

import models.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="USER_COMMUNICATION", schema= Constants.SCHEMA_NAME_REABTE_TRANSACTION)
public class UserCommunication implements Serializable{

	@Id
	@Column(name="USER_ID", length=100, nullable=false)
	public Long userId;
	
	@Column(name="COMMUNICATION_ID", length=100, nullable=false)
	public Long communicationId;
	
}
