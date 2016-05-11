package models.abergin;

import application.STATUS;
import models.Constants;
import models.address.UserAddress;
import models.friends.UserFriend;
import models.payments.UserPaymentOption;
import models.useractivities.UserPoints;
import models.useractivities.UserTransaction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="USERS", schema= Constants.SCHEMA_NAME_REABTE_ABERGIN)
public class AUser implements Serializable{

	public AUser(String userType) {
		this.userType = userType;
	}
	
	public AUser(Long userId) {
		this.userId = userId;
	}
	
	public AUser() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_TYPE", length=15)
	private String userType;

	@Column(name = "NAME", length = 20)
	private String name;

	@Column(name = "EMAIL", length = 30, unique = true)
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastLogin;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdOn;

	@Column(name = "STATUS")
	@Enumerated(value = EnumType.ORDINAL)
	private STATUS status;

	@OneToOne(mappedBy="user")
	private UserToken userToken;
	
	@OneToMany(mappedBy="userIdAddressId.user")
	public Set<UserAddress> userAddress;

	@OneToOne(mappedBy = "user")
	private UserPoints userPoints;

	@OneToMany(mappedBy="user")
	public Set<UserTransaction> userTransactionSet;

	@OneToMany(mappedBy="userIdPaymentOptionId.user")
	public Set<UserPaymentOption> userPaymentOptionSet;

	@OneToMany(mappedBy="userIdFriendId.user")
	public Set<UserFriend> userFriendSet;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
