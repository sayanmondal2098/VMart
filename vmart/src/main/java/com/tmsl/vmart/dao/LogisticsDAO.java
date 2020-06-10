package com.tmsl.vmart.dao;

import org.json.JSONObject;

import com.tmsl.vmart.model.Logistics;

public interface LogisticsDAO {
	
	public JSONObject getUserCoordinates(String q);
	
	public JSONObject getDistanceMatrix(String origin,String destination);
	
	public Logistics getLogisticalInfo(Double distance);

}
