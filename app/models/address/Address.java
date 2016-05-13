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
	private Long addressId;
	
	@Column(name="ADDRESS_HEADING", length=30, nullable=false)
	private String addressHeading;
	
	@Column(name="PINCODE", length=10, nullable=false)
	private String pincode;
	
	@Column(name = "ADDRESS", columnDefinition = "text")
	private String address;
	
	@Column(name="LANDMARK", length=100)
	private String landmark;
	
	@Column(name="PHONE_NO", length=15)
	private String phoneNo;
	
	@Column(name="CITY", length=20)
	private String city;
	
	@Column(name="STATE", length=20)
	private String state;
	
	@Column(name="COUNTRY", length=20)
	private String country;
	
	@OneToMany(mappedBy="userIdAddressId.address", cascade=CascadeType.ALL)
	private Set<UserAddress> userAddress;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressHeading() {
		return addressHeading;
	}

	public void setAddressHeading(String addressHeading) {
		this.addressHeading = addressHeading;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Set<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}
}
