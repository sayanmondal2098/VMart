package com.tmsl.vmart.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.tmsl.vmart.config.ApplicationContextConfig;
import com.tmsl.vmart.dao.LogisticsDAO;
import com.tmsl.vmart.model.Logistics;

@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class LogisticsDAOImpl implements LogisticsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	public LogisticsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public JSONObject getUserCoordinates(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject getDistanceMatrix(String origin, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	public Logistics getLogisticalInfo(Double distance) {
		// TODO Auto-generated method stub
		return null;
	}

}
