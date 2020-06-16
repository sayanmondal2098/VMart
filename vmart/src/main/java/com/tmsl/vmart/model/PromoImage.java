package com.tmsl.vmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PromoImage {
	
	private Long promoID;
	private String name;
	private String url;
	private String redirect;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPromoID() {
		return promoID;
	}
	
	public void setPromoID(Long promoID) {
		this.promoID = promoID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getRedirect() {
		return redirect;
	}
	
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
}
