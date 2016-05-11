package models.address;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="ADDRESS", schema= Constants.SCHEMA_NAME_REABTE_ADDRESS)
public class Address implements Serializable{

	public Address() {}
	
	public Address(String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country) {
	
		this.addressHeading = addressHeading;
		this.pincode = pincode;
		this.address = address;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID")
	public Long addressId;
	
	@Column(name="ADDRESS_HEADING", length=30, nullable=false)
	public String addressHeading;
	
	@Column(name="PINCODE", length=10, nullable=false)
	public String pincode;
	
	@Column(name = "ADDRESS", columnDefinition = "text")
	public String address;
	
	@Column(name="LANDMARK", length=100)
	public String landmark;
	
	@Column(name="PHONE_NO", length=15)
	public String phoneNo;
	
	@Column(name="CITY", length=20)
	public String city;
	
	@Column(name="STATE", length=20)
	public String state;
	
	@Column(name="COUNTRY", length=20)
	public String country;
	
	@OneToMany(mappedBy="userIdAddressId.address", cascade=CascadeType.ALL)
	public Set<UserAddress> userAddress;
}
