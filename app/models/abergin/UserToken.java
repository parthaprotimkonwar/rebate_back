package models.abergin;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="USER_TOKEN", schema= Constants.SCHEMA_NAME_REABTE_ABERGIN)
public class UserToken implements Serializable{

	public UserToken() {}
	
	public UserToken(String tokenId, Date expiryDateTime, AUser user) {
		this.tokenId = tokenId;
		this.expiryDateTime = expiryDateTime;
		this.user = user;
	}
	
	@Id
	@Column(name="TOKEN_ID", length=100)
	public String tokenId;
	
	@Column(name="EXPIRY_DATETIME", length=20)
	@Temporal(TemporalType.TIMESTAMP)
	public Date expiryDateTime;
	
	/*@Column(name="EXPIRY_DATETIME", length=20)
	public Long expiryDateTime;*/
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn
	public AUser user;
}
