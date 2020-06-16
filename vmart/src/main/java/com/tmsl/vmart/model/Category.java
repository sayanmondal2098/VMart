package com.tmsl.vmart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {

	private Long catID;
	private String catName;
	private String sizeChart;

	private Set<Product> products = new HashSet<Product>();

	private String picUrl;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCatID() {
		return catID;
	}

	public void setCatID(Long catID) {
		this.catID = catID;
	}

	public String getSizeChart() {
		return sizeChart;
	}

	public void setSizeChart(String sizeChart) {
		this.sizeChart = sizeChart;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
