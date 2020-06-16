package com.tmsl.vmart.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {

	private Long pid;
	private Set<String> picList = new HashSet<String>();
	private String name;
	private Category category;
	private Double price;
	private Double discount;
	private Seller seller;
	private Set<String> specification = new HashSet<String>();
	private String description;
	private List<Rating> ratings = new ArrayList<Rating>(); // list

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	public Set<String> getPicList() {
		return picList;
	}

	public void setPicList(Set<String> picList) {
		this.picList = picList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catID", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerID", nullable = false)

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	public Set<String> getSpecification() {
		return specification;
	}

	public void setSpecification(Set<String> specification) {
		this.specification = specification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

}
