package com.tmsl.vmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AdminSeller")
public class AdminSeller {

	private long as_id;
	private String name;
	private String email;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAs_id() {
		return as_id;
	}

	public void setAs_id(long as_id) {
		this.as_id = as_id;
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

}
