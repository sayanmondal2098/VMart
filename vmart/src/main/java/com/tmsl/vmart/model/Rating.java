package com.tmsl.vmart.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

	private Long rateID;
	private Product product;
	private Customer customer;
	private Double ratings;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getRateID() {
		return rateID;
	}

	public void setRateID(Long rateID) {
		this.rateID = rateID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

}
