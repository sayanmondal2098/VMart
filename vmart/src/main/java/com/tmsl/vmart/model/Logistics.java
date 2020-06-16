package com.tmsl.vmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logistical_info")
public class Logistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lid;
	private Double distanceLowerRange;
	private Double distanceUpperRange;
	private Double deliveryChargeAmount;
	
	public Long getLid() {
		return lid;
	}
	
	public void setLid(Long lid) {
		this.lid = lid;
	}
	
	public Double getDistanceLowerRange() {
		return distanceLowerRange;
	}
	
	public void setDistanceLowerRange(Double distanceLowerRange) {
		this.distanceLowerRange = distanceLowerRange;
	}
	
	public Double getDistanceUpperRange() {
		return distanceUpperRange;
	}
	
	public void setDistanceUpperRange(Double distanceUpperRange) {
		this.distanceUpperRange = distanceUpperRange;
	}
	
	public Double getDeliveryChargeAmount() {
		return deliveryChargeAmount;
	}
	
	public void setDeliveryChargeAmount(Double deliveryChargeAmount) {
		this.deliveryChargeAmount = deliveryChargeAmount;
	}
	
	

}
