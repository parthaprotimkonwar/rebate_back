package models.abergin;

import application.enums.STATUS;
import application.enums.USER_TYPE;
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

	public AUser() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_TYPE")
	@Enumerated(value = EnumType.ORDINAL)
	private USER_TYPE userType;

	@Column(name = "NAME", length = 20)
	private String name;

	@Column(name = "EMAIL", length = 30, unique = true)
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IMAGE_URL", columnDefinition = "text")
	private String imageUrl;

	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "STATUS")
	@Enumerated(value = EnumType.ORDINAL)
	private STATUS status;

	@OneToOne(mappedBy="user")
	private UserToken userToken;
	
	@OneToMany(mappedBy="userIdAddressId.user")
	private Set<UserAddress> userAddressSet;

	@OneToOne(mappedBy = "user")
	private UserPoints userPoints;

	@OneToMany(mappedBy="user")
	private Set<UserTransaction> userTransactionSet;

	@OneToMany(mappedBy="userIdPaymentOptionId.user")
	private Set<UserPaymentOption> userPaymentOptionSet;

	@OneToMany(mappedBy="userIdFriendId.user")
	private Set<UserFriend> userFriendSet;

	public AUser(USER_TYPE userType, String name, String email, String password, String imageUrl, Date lastLogin, Date createdOn, STATUS status) {
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public void setUserType(USER_TYPE userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public UserToken getUserToken() {
		return userToken;
	}

	public Set<UserAddress> getUserAddressSet() {
		return userAddressSet;
	}

	public UserPoints getUserPoints() {
		return userPoints;
	}

	public Set<UserTransaction> getUserTransactionSet() {
		return userTransactionSet;
	}

	public Set<UserPaymentOption> getUserPaymentOptionSet() {
		return userPaymentOptionSet;
	}

	public Set<UserFriend> getUserFriendSet() {
		return userFriendSet;
	}
}
