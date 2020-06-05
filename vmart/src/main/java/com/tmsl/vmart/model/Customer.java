package com.tmsl.vmart.model;

/*
 * @author: Saptak Das
 * @date: 31-05-2020
 * @version: 1.0
 * @copyright: www.thehealthsync.com
 * 
 * */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {

	private long cid;
	private String name;
	private String email;
	private String password;
	private List<Rating> ratings = new ArrayList<Rating>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
