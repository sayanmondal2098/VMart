package com.tmsl.vmart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Seller")
public class Seller {

	private long sellerID;
	private String name;
	private String password;
	private String address;
	private String phoneNo;
	private String gpsCoordinates;
	private Character verified;
	private Set<Product> products = new HashSet<Product>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSellerID() {
		return sellerID;
	}

	public void setSellerID(Long sellerID) {
		this.sellerID = sellerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGpsCoordinates() {
		return gpsCoordinates;
	}

	public void setGpsCoordinates(String gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}

	public Character getVerified() {
		return verified;
	}

	public void setVerified(Character verified) {
		this.verified = verified;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
